package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "emotions")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmotionsEntity {

    @Id
    @Column(name = "idemotion", nullable = false)
    @GeneratedValue
    private Long idEmotion;

    @Column(name = "emotion", nullable = false)
    private String emotion;
}
