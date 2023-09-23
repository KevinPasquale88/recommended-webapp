package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "reviewsfromusers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsFromUsers {

    @Id
    @Column(name = "idreviewfromuser", nullable = false)
    @GeneratedValue
    private Long idReviewFromUser;

    @Column(name = "iduser", nullable = false)
    private Long idUser;

    @Column(name = "idreview", nullable = false)
    private Long idReview;

    @Override
    public String toString() {
        return String.format("idReviewFromUser=%d idUser=%d idReview=%d", idReviewFromUser, idUser, idReview);
    }

}
