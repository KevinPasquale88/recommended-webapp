package it.sysagent.recommended.recommendedwebapp.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Emotions {

    private Long idEmotion;

    private String emotion;

    @Builder
    public Emotions(Long idEmotion, String emotion) {
        this.idEmotion = idEmotion;
        this.emotion = emotion;
    }
}
