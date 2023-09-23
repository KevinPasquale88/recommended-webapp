package it.sysagent.recommended.recommendedwebapp.entity;

import it.sysagent.recommended.recommendedwebapp.dto.User;
import lombok.*;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {

    @Id
    @Column(name = "iduser", nullable = false)
    @GeneratedValue
    private Long idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "authorizationRecord")
    private Boolean authorizationRecord;


    public UsersEntity(User user) {
        this.name = user.getName();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.authorizationRecord = user.isAuthorizationRecording();
    }

    public User getUser() {
        User user = new User();
        user.setGender(this.gender);
        user.setAge(this.age);
        user.setName(this.name);
        return user;
    }
}
