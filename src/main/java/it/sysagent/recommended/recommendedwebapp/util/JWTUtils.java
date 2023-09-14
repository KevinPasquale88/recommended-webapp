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

@Slf4j
public class JWTUtils {

    public static String generate(UsersEntity user){
        try {
            Algorithm algorithm = Algorithm.HMAC384("jojolo");
            return JWT.create()
                    .withClaim("id", String.valueOf(user.getId_user()))
                    .withClaim("nickname", user.getNickname())
                    .withClaim("age", user.getAge())
                    .withClaim("gender", user.getGender())
                    .withIssuer("user")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            log.error(ExceptionUtils.getStackTrace(exception));
        }
        return user.getNickname();
    }

    public static UsersEntity decode(String token){
        UsersEntity user = new UsersEntity();
        try {
            Algorithm algorithm = Algorithm.HMAC384("jojolo");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("user")
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
            decodedJWT.getClaims().forEach((key, value) -> {
                switch (key) {
                    case "nickname" -> user.setNickname(value.asString());
                    case "age" -> user.setAge(value.asInt());
                    case "gender" -> user.setGender(value.asString());
                    case "id" -> user.setId_user(Long.parseLong(value.asString()));
                }
            });
        } catch (JWTVerificationException exception){
            log.error(ExceptionUtils.getMessage(exception));
        }
        return user;
    }
}
