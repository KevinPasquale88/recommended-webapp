package it.sysagent.recommended.recommendedwebapp.service;

import it.sysagent.recommended.recommendedwebapp.dto.AuthUser;
import it.sysagent.recommended.recommendedwebapp.dto.User;
import it.sysagent.recommended.recommendedwebapp.entity.AuthUserEntity;
import it.sysagent.recommended.recommendedwebapp.entity.UsersEntity;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryAuthUser;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryUsers;
import it.sysagent.recommended.recommendedwebapp.util.JWTUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserServiceTest {

    private final RepositoryUsers repositoryUsers = Mockito.mock(RepositoryUsers.class);
    private final RepositoryAuthUser repositoryAuthUser = Mockito.mock(RepositoryAuthUser.class);
    private final UserService userService = Mockito.spy(new UserService(repositoryUsers, repositoryAuthUser));

    @Test
    public void testUserSession() {
        ReflectionTestUtils.setField(JWTUtils.class, "secret", "secret");
        User user = new User("name", "male", 35, true);
        UsersEntity userEntity = new UsersEntity(user);
        userEntity.setIdUser(1L);
        Mockito.doReturn(userEntity).when(repositoryUsers).save(Mockito.any(UsersEntity.class));
        String token = userService.userSession(user);
        assertNotEquals(token, "");
        System.out.println(token);
        Mockito.verify(repositoryUsers, Mockito.times(1)).save(Mockito.any(UsersEntity.class));
    }

    @Test
    public void authUserTest() {
        Mockito.doReturn(List.of(new AuthUserEntity(1L, "username", "password"))).when(repositoryAuthUser).findByUser(Mockito.anyString());
        AuthUser authUser = new AuthUser("username", "password");
        String result = userService.authUser(authUser);
        assertEquals("OK", result);
        Mockito.verify(repositoryAuthUser, Mockito.times(1)).findByUser(Mockito.anyString());
    }
}
