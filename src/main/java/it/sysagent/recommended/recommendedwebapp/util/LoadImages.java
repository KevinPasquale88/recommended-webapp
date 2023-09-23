package it.sysagent.recommended.recommendedwebapp.util;

import it.sysagent.recommended.recommendedwebapp.entity.ImagesEntity;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component(LoadImages.ENTITY)
public class LoadImages {
    public static final String ENTITY = "LOAD-IMAGES";

    private final List<ImagesEntity> imagesEntity;

    @Autowired
    public LoadImages(@Qualifier(RepositoryImages.ENTITY) RepositoryImages repositoryImages) {
        this.imagesEntity = new ArrayList<>(repositoryImages.findAll());
    }

    public ImagesEntity getImagesEntity() {
        ImagesEntity image = this.imagesEntity.get(this.random());
        this.imagesEntity.remove(image);
        return image;
    }

    protected int random() {
        Random random = new Random();
        return random.nextInt(imagesEntity.size());
    }
}
