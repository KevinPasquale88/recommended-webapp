package it.sysagent.recommended.recommendedwebapp.util;

import it.sysagent.recommended.recommendedwebapp.entity.ImagesEntity;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryImages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadImagesTest {

    private final RepositoryImages repositoryImages = Mockito.mock(RepositoryImages.class);
    private LoadImages loadImages;

    @BeforeEach
    public void beforeEach() {
        Mockito.doReturn(
                List.of(
                        new ImagesEntity(1L, "image", 1L),
                        new ImagesEntity(2L, "image3", 2L)
                )).when(repositoryImages).findAll();
        loadImages = Mockito.spy(new LoadImages(repositoryImages));
    }

    @Test
    public void testGetImagesEntity() {
        ImagesEntity image = loadImages.getImagesEntity();
        assertNotNull(image);
        Mockito.verify(repositoryImages, Mockito.times(1)).findAll();
        Mockito.verify(repositoryImages, Mockito.times(1)).findAll();
    }

    @Test
    public void testRandom() {
        int random = loadImages.random();
        assertTrue(random >= 0 && random < 2);
    }
}
