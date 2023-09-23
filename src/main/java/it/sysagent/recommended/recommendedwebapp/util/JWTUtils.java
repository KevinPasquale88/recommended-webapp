package it.sysagent.recommended.recommendedwebapp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import it.sysagent.recommended.recommendedwebapp.entity.UsersEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class JWTUtils {

    @Value("${jwt.secret}")
    private static String secret;

    public static String generate(UsersEntity user) {
        try {
            Algorithm algorithm = Algorithm.HMAC384(secret);
            return JWT.create()
                    .withClaim("id", String.valueOf(user.getIdUser()))
                    .withClaim("name", user.getName())
                    .withClaim("age", user.getAge())
                    .withClaim("gender", user.getGender())
                    .withClaim("authorizationRecord", user.getAuthorizationRecord())
                    .withIssuer("user")
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            log.error(ExceptionUtils.getStackTrace(exception));
        }
        return user.getName();
    }

    public static UsersEntity decode(String token) {
        UsersEntity user = new UsersEntity();
        try {
            Algorithm algorithm = Algorithm.HMAC384(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("user")
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
            decodedJWT.getClaims().forEach((key, value) -> {
                switch (key) {
                    case "nickname" -> user.setName(value.asString());
                    case "age" -> user.setAge(value.asInt());
                    case "gender" -> user.setGender(value.asString());
                    case "id" -> user.setIdUser(Long.parseLong(value.asString()));
                    case "authorizationRecord" -> user.setAuthorizationRecord(value.asBoolean());
                }
            });
        } catch (JWTVerificationException exception) {
            log.error(ExceptionUtils.getMessage(exception));
        }
        return user;
    }
}
