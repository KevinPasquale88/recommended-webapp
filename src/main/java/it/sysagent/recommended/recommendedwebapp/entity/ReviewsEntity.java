package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "reviews")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsEntity {

    @Id
    @Column(name = "idreview", nullable = false)
    @GeneratedValue
    private Long idReview;

    @Column(name = "idimage", nullable = false)
    private Long idImage;

    @Column(name = "comment")
    private String comment;

    @Column(name = "idemotion", nullable = false)
    private Long idEmotion;

    @Override
    public String toString() {
        return String.format("idReview=%d idImage=%d comment=%s idEmotion=%d", idReview, idImage, comment, idEmotion);
    }
}
