package it.sysagent.recommended.recommendedwebapp.service;

import it.sysagent.recommended.recommendedwebapp.dto.AuthUser;
import it.sysagent.recommended.recommendedwebapp.dto.User;
import it.sysagent.recommended.recommendedwebapp.entity.AuthUserEntity;
import it.sysagent.recommended.recommendedwebapp.entity.UsersEntity;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryAuthUser;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryUsers;
import it.sysagent.recommended.recommendedwebapp.util.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(UserService.ENTITY)
public class UserService {

    public final static String ENTITY = "USER-SERVICE";

    private final RepositoryUsers repositoryUsers;

    private final RepositoryAuthUser repositoryAuthUser;

    @Autowired
    public UserService(@Qualifier(RepositoryUsers.ENTITY) RepositoryUsers repositoryUsers,
                       @Qualifier(RepositoryAuthUser.ENTITY) RepositoryAuthUser repositoryAuthUser) {
        this.repositoryUsers = repositoryUsers;
        this.repositoryAuthUser = repositoryAuthUser;
    }

    public String userSession(User user) {
        UsersEntity userEntity = repositoryUsers.save(new UsersEntity(user));
        return JWTUtils.generate(userEntity);
    }

    public String authUser(AuthUser authUser) {
        List<AuthUserEntity> entity = repositoryAuthUser.findByUser(authUser.getUser());
        if (entity != null && !entity.isEmpty() && StringUtils.equals(entity.get(0).getPwd(), authUser.getPwd())) {
            return "OK";
        }
        return "KO";
    }
}
