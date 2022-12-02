package it.sysagent.recommended.recommendedwebapp.entity;

import it.sysagent.recommended.recommendedwebapp.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Table(name="users")
@Entity
@Data
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
}
