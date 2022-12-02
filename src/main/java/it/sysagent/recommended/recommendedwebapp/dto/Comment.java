package it.sysagent.recommended.recommendedwebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String comment;

    private String image;

    private String jwt;
}
