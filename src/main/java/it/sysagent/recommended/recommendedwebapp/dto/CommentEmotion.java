package it.sysagent.recommended.recommendedwebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentEmotion {

    private String comment;

    private Long idImage;

    private Long idEmotion;
}
