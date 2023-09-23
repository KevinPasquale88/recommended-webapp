package it.sysagent.recommended.recommendedwebapp.util;

import it.sysagent.recommended.recommendedwebapp.entity.UsersEntity;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JWTUtilsTest {


    @Test
    public void testGenerateToken() {
        ReflectionTestUtils.setField(JWTUtils.class, "secret", "secret");
        UsersEntity usersEntity = new UsersEntity(1L, "username", 35, "male", true);
        String token = JWTUtils.generate(usersEntity);
        System.out.println(token);
        assertNotNull(token);
    }

    @Test
    public void testDecodeToken() {
        ReflectionTestUtils.setField(JWTUtils.class, "secret", "secret");
        UsersEntity usersEntity = JWTUtils.decode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJnZW5kZXIiOiJtYWxlIiwiYXV0aG9yaXphdGlvblJlY29yZCI6dHJ1ZSwibmFtZSI6InVzZXJuYW1lIiwiaXNzIjoidXNlciIsImlkIjoiMSIsImFnZSI6MzV9.Xc27lkXoSdEjxiXS85zy9n6ZqPS0LMLEjxLuEHenWmd2-swu2DVaJHvstHhDEtY5");
        System.out.println(usersEntity);
        assertNotNull(usersEntity);
    }

}
