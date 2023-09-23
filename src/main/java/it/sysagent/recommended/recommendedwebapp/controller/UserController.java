package it.sysagent.recommended.recommendedwebapp.controller;

import it.sysagent.recommended.recommendedwebapp.dto.AuthUser;
import it.sysagent.recommended.recommendedwebapp.dto.User;
import it.sysagent.recommended.recommendedwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(@Qualifier(UserService.ENTITY) UserService userService) {
        this.userService = userService;
    }

    @PutMapping(value = "/userSession", produces = MediaType.TEXT_HTML_VALUE)
    public String userSession(@RequestBody User user) {
        return userService.userSession(user);
    }

    @PutMapping(value = "/auth", produces = MediaType.TEXT_HTML_VALUE)
    public String auth(@RequestBody AuthUser auth) {
        if (auth != null) {
            return userService.authUser(auth);
        } else {
            return "KO";
        }
    }
}
