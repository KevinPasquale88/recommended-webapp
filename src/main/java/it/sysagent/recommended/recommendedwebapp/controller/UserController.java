package it.sysagent.recommended.recommendedwebapp.controller;

import it.sysagent.recommended.recommendedwebapp.dto.AuthUser;
import it.sysagent.recommended.recommendedwebapp.dto.User;
import it.sysagent.recommended.recommendedwebapp.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/userSession")
    public String userSession(User user) {
        return userService.userSession(user);
    }

    @PutMapping("/auth")
    public String auth(AuthUser auth) {
        if (auth != null){
            return userService.authUser(auth);
        } else {
            return "KO";
        }
    }
}
