package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "reviews_images")
@Entity
@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReviewsEntity that = (ReviewsEntity) o;
        return idreviews_images != null && Objects.equals(idreviews_images, that.idreviews_images);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
