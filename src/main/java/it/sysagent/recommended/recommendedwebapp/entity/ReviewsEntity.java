package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "reviews_images")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsEntity {

    @Id
    @Column(name = "idreviews_images", nullable = false)
    @GeneratedValue
    private Long idreviews_images;

    private String image;

    private Double review;

    private String description;
}
