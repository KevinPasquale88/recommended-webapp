package it.sysagent.recommended.recommendedwebapp.repository;

import it.sysagent.recommended.recommendedwebapp.entity.ImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(RepositoryImages.ENTITY)
public interface RepositoryImages extends JpaRepository<ImagesEntity, Long> {

    String ENTITY = "IMAGES-REPOSITORY";

}
