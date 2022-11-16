package it.sysagent.recommended.recommendedwebapp.service;

import it.sysagent.recommended.recommendedwebapp.dto.User;
import it.sysagent.recommended.recommendedwebapp.util.JWTUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String authUser(User user){
        return JWTUtils.generate(user);
    }
}
