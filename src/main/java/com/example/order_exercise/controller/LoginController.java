package com.example.order_exercise.controller;

import com.example.order_exercise.repository.UserRepository;
import com.example.order_exercise.security.Role;
import com.example.order_exercise.service.UserService;
import com.example.order_exercise.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        String nameUser = (String) userService.findById(id).getFirstname() + " " + (String) userService.findById(id).getLastname();
        loginService.setRole(roleUser);
        loginService.setName(nameUser);
        return roleUser;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseEntity<String> handleContentNotAllowedException(NullPointerException cnae) {
        return new ResponseEntity<>("No user found", HttpStatus.UNAUTHORIZED);
    }

}
