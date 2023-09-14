package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name="authuser")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserEntity {
    @Id
    @Column(name = "idauthuser", nullable = false)
    private Long idauthuser;

    private String user;

    private String pwd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AuthUserEntity that = (AuthUserEntity) o;
        return idauthuser != null && Objects.equals(idauthuser, that.idauthuser);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
