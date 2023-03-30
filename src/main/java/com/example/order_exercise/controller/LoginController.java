package com.example.order_exercise.controller;

import com.example.order_exercise.repository.UserRepository;
import com.example.order_exercise.security.Role;
import com.example.order_exercise.service.UserService;
import com.example.order_exercise.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final LoginService loginService;

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public LoginController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @GetMapping("/{id}")
    public Role findbyId(@PathVariable("id") String id){
        Role roleUser = userService.findById(id).getRole();
        loginService.setRole(roleUser);
        return roleUser;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public void handleException(NullPointerException ex){
        logger.error("No such user in database.");

    }

}
