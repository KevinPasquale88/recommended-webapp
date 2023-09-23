package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "images")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImagesEntity {

    @Id
    @Column(name = "idimage", nullable = false)
    @GeneratedValue
    private Long idImage;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "idemotion", nullable = false)
    private Long idEmotion;
}
