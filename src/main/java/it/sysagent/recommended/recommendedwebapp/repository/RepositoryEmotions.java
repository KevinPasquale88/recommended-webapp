package it.sysagent.recommended.recommendedwebapp.repository;

import it.sysagent.recommended.recommendedwebapp.entity.EmotionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(RepositoryEmotions.ENTITY)
public interface RepositoryEmotions extends JpaRepository<EmotionsEntity, Long> {

        String ENTITY = "EMOTIONS-REPOSITORY";
}
