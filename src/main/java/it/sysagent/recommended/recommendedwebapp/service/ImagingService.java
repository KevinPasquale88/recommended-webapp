package it.sysagent.recommended.recommendedwebapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.sysagent.recommended.recommendedwebapp.dto.Comment;
import it.sysagent.recommended.recommendedwebapp.entity.ReviewsEntity;
import it.sysagent.recommended.recommendedwebapp.entity.ReviewsUsers;
import it.sysagent.recommended.recommendedwebapp.entity.UsersEntity;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryReviews;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryReviewsUsers;
import it.sysagent.recommended.recommendedwebapp.util.CreateRequestSentence;
import it.sysagent.recommended.recommendedwebapp.util.Descriptors;
import it.sysagent.recommended.recommendedwebapp.util.JWTUtils;
import it.sysagent.recommended.recommendedwebapp.util.POSTClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class ImagingService {

    private List<String> images;

    @Value("${service.host.sentences}")
    private String host;

    @Autowired
    private RepositoryReviews repositoryReviews;

    @Autowired
    private RepositoryReviewsUsers repositoryReviewsUsers;

    @Autowired
    public ImagingService() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        images = new ArrayList<>();
        listFilesForFolder(new File(classloader.getResource("images").getFile()));
    }

    public String get() {
        Random random = new Random();
        int elem = random.nextInt(images.size());
        String image = images.get(elem);
        images.remove(image);
        return image;
    }

    private void listFilesForFolder(final File folder) {
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                images.add(fileEntry.getAbsolutePath());
            }
        }
    }

    public void putComment(Comment comment) {
        ObjectMapper Obj = new ObjectMapper();
        POSTClient client = new POSTClient(this.host);
        try {
            client.createRequest(Obj.writeValueAsString(CreateRequestSentence.create(comment.getComment())), "/model");
            String response = client.call();
            response = StringUtils.replace(response, " ", "A").replaceAll("[^A-Za-z0-9.]", "");
            List<Double> ratings = Arrays.stream(StringUtils.split(response, "A"))
                    .map(Double::parseDouble).collect(Collectors.toList());

            int index = IntStream.range(0, ratings.size())
                    .boxed().max(Comparator.comparing(ratings::get))
                    .get();
            UsersEntity user = JWTUtils.decode(comment.getComment());
            ReviewsEntity reviewsEntity = new ReviewsEntity();
            reviewsEntity.setReview(ratings.get(index));
            reviewsEntity.setImage(comment.getImage());
            reviewsEntity.setDescription(Descriptors.scale[index]);
            reviewsEntity = repositoryReviews.save(reviewsEntity);

            ReviewsUsers connect = new ReviewsUsers();
            connect.setId_user(user.getId_user());
            connect.setIdreviews_images(reviewsEntity.getIdreviews_images());
            repositoryReviewsUsers.save(connect);
        } catch (URISyntaxException | JsonProcessingException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }
}
