package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "reviews_images")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsEntity {

    @Id
    private Long idreviews_images;

    private String image;

    private Double review;

    private Long id_user;
}
