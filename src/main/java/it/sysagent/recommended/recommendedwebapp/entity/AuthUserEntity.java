package it.sysagent.recommended.recommendedwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="authuser")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserEntity {
    @Id
    @Column(name = "idauthuser", nullable = false)
    private Long idauthuser;

    private String user;

    private String pwd;
}
