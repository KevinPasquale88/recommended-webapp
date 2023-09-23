package it.sysagent.recommended.recommendedwebapp.service;

import it.sysagent.recommended.recommendedwebapp.dto.Emotions;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryEmotions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(EmotionsService.ENTITY)
public class EmotionsService {

    public final static String ENTITY = "EMOTIONS-SERVICE";

    private final RepositoryEmotions repositoryEmotions;

    @Autowired
    public EmotionsService(@Qualifier(RepositoryEmotions.ENTITY) RepositoryEmotions repositoryEmotions) {
        this.repositoryEmotions = repositoryEmotions;
    }

    public List<Emotions> getEmotions() {
        return repositoryEmotions.findAll()
                .stream()
                .map(emotionsEntity ->
                        Emotions.builder()
                                .emotion(emotionsEntity.getEmotion())
                                .idEmotion(emotionsEntity.getIdEmotion())
                                .build())
                .collect(Collectors.toList());
    }
}
