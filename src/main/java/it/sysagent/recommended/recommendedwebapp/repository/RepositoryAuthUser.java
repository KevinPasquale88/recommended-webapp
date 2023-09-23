package it.sysagent.recommended.recommendedwebapp.repository;

import it.sysagent.recommended.recommendedwebapp.entity.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(RepositoryAuthUser.ENTITY)
public interface RepositoryAuthUser extends JpaRepository<AuthUserEntity, Long> {

    String ENTITY = "AUTH-USER-REPOSITORY";

    List<AuthUserEntity> findByUser(String user);
}
