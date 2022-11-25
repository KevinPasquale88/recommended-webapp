package it.sysagent.recommended.recommendedwebapp.repository;

import it.sysagent.recommended.recommendedwebapp.entity.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryAuthUser extends JpaRepository<AuthUserEntity, Long> {

    List<AuthUserEntity> findByUser(String user);
}
