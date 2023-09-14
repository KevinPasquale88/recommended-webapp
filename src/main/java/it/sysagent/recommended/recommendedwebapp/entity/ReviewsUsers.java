package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name="reviews_users")
@Entity
@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReviewsUsers that = (ReviewsUsers) o;
        return idreviews_users != null && Objects.equals(idreviews_users, that.idreviews_users);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
