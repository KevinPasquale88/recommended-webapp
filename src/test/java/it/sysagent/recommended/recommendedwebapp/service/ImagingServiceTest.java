package it.sysagent.recommended.recommendedwebapp.service;

import it.sysagent.recommended.recommendedwebapp.dto.Image;
import it.sysagent.recommended.recommendedwebapp.entity.ImagesEntity;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryReviews;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryReviewsUsers;
import it.sysagent.recommended.recommendedwebapp.util.LoadImages;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ImagingServiceTest {

    private final RepositoryReviews repositoryReviews = Mockito.mock(RepositoryReviews.class);
    private final RepositoryReviewsUsers repositoryReviewsUsers = Mockito.mock(RepositoryReviewsUsers.class);
    private final LoadImages loadImages = Mockito.mock(LoadImages.class);
    private final ImagingService imagingService = Mockito.spy(new ImagingService(repositoryReviews, repositoryReviewsUsers, loadImages));

    @Test
    public void getImagesTest() throws Exception {

        Mockito.doReturn(new ImagesEntity(1L, "test.txt", 2L)).when(loadImages).getImagesEntity();
        Image result = imagingService.getImages();
        assertNotEquals(null, result);
    }
}
