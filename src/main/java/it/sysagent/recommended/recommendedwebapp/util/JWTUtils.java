package it.sysagent.recommended.recommendedwebapp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import it.sysagent.recommended.recommendedwebapp.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

@Slf4j
public class JWTUtils {

    public static String generate(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC384("jojolo");
            return JWT.create()
                    .withClaim("nickname", user.getNickName())
                    .withClaim("age", user.getAge())
                    .withClaim("gender", user.getGender())
                    .withIssuer("user")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            log.error(ExceptionUtils.getStackTrace(exception));
        }
        return user.getNickName();
    }

    public static User decode(String token){
        User user = new User();
        try {
            Algorithm algorithm = Algorithm.HMAC384("jojolo");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("user")
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
            decodedJWT.getClaims().entrySet().stream().forEach(elem ->{
                switch(elem.getKey()){
                    case "nickname":
                        user.setNickName(elem.getValue().asString());
                    break;
                    case "age":
                        user.setAge(elem.getValue().asInt());
                        break;
                    case "gender":
                        user.setGender(elem.getValue().asString());
                        break;
                }
            });
        } catch (JWTVerificationException exception){
        }
        return user;
    }
}
