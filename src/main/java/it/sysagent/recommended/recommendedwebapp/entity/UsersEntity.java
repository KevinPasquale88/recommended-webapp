package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {

    @Id
    private Long id_user;

    private String nickname;

    private Integer age;

    private String gender;

}
