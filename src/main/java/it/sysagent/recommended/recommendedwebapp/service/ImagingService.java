package it.sysagent.recommended.recommendedwebapp.service;

import it.sysagent.recommended.recommendedwebapp.dto.CommentEmotion;
import it.sysagent.recommended.recommendedwebapp.dto.Image;
import it.sysagent.recommended.recommendedwebapp.entity.ImagesEntity;
import it.sysagent.recommended.recommendedwebapp.entity.ReviewsEntity;
import it.sysagent.recommended.recommendedwebapp.entity.ReviewsFromUsers;
import it.sysagent.recommended.recommendedwebapp.entity.UsersEntity;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryReviews;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryReviewsUsers;
import it.sysagent.recommended.recommendedwebapp.util.JWTUtils;
import it.sysagent.recommended.recommendedwebapp.util.LoadImages;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Service(ImagingService.ENTITY)
public class ImagingService {

    public final static String ENTITY = "IMAGING-SERVICE";

    private final RepositoryReviews repositoryReviews;

    private final RepositoryReviewsUsers repositoryReviewsUsers;

    private final LoadImages loadImages;

    @Autowired
    public ImagingService(@Qualifier(RepositoryReviews.ENTITY) RepositoryReviews repositoryReviews,
                          @Qualifier(RepositoryReviewsUsers.ENTITY) RepositoryReviewsUsers repositoryReviewsUsers,
                          @Qualifier(LoadImages.ENTITY) LoadImages loadImages) {
        this.repositoryReviews = repositoryReviews;
        this.repositoryReviewsUsers = repositoryReviewsUsers;
        this.loadImages = loadImages;
    }

    public Image getImages() throws IOException {
        ImagesEntity imageEntity = this.loadImages.getImagesEntity();
        //TODO SAVE JPEG IMAGE IN DB https://www.kodyaz.com/t-sql/save-image-to-database-table-in-sql-server.aspx
        return Image.builder()
                .data(IOUtils.toByteArray(
                                Objects.requireNonNull(
                                        getClass().getClassLoader().getResourceAsStream(imageEntity.getPath())
                                )
                        )
                )
                .idImage(imageEntity.getIdImage())
                .build();
    }

    public void putComment(String jwt, CommentEmotion comment) {

        UsersEntity user = JWTUtils.decode(jwt);
        ReviewsEntity reviewsEntity = new ReviewsEntity();

        reviewsEntity.setComment(comment.getComment());
        reviewsEntity.setIdEmotion(comment.getIdEmotion());
        reviewsEntity.setIdImage(comment.getIdImage());
        reviewsEntity = repositoryReviews.save(reviewsEntity);
        log.info("reviewsEntity {}", reviewsEntity);
        ReviewsFromUsers reviewsFromUsers = new ReviewsFromUsers();
        reviewsFromUsers.setIdUser(user.getIdUser());
        reviewsFromUsers.setIdReview(reviewsEntity.getIdReview());
        reviewsFromUsers = repositoryReviewsUsers.save(reviewsFromUsers);
        log.info("connect {}", reviewsFromUsers);

        //TODO SAVE RECORDS VIDEO
    }
}
