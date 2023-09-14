package it.sysagent.recommended.recommendedwebapp.entity;

import it.sysagent.recommended.recommendedwebapp.dto.User;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name="users")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {

    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue
    private Long id_user;

    private String nickname;

    private Integer age;

    private String gender;

    public UsersEntity(User user){
        this.nickname = user.getNickName();
        this.age = user.getAge();
        this.gender = user.getGender();
    }

    public User getUser(){
        User user = new User();
        user.setGender(this.gender);
        user.setAge(this.age);
        user.setNickName(this.nickname);
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsersEntity entity = (UsersEntity) o;
        return id_user != null && Objects.equals(id_user, entity.id_user);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
