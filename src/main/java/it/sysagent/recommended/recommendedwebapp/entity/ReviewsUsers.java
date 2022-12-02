package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="reviews_users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsUsers {

    @Id
    @Column(name = "idreviews_users", nullable = false)
    @GeneratedValue
    private Long idreviews_users;

    @Column(name = "idreviews_images", nullable = false)
    private Long idreviews_images;

    @Column(name = "id_user", nullable = false)
    private Long id_user;
}
