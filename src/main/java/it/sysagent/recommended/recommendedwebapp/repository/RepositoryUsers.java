package it.sysagent.recommended.recommendedwebapp.repository;

import it.sysagent.recommended.recommendedwebapp.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(RepositoryUsers.ENTITY)
public interface RepositoryUsers extends JpaRepository<UsersEntity, Long> {

    String ENTITY = "USERS-REPOSITORY";

}
