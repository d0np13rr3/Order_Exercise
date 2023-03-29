package com.example.order_exercise.controller;

import com.example.order_exercise.dto.CustomerDTO;
import com.example.order_exercise.repository.CustomerRepository;
import com.example.order_exercise.security.Role;
import com.example.order_exercise.service.CustomerService;
import com.example.order_exercise.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final CustomerService customerService;
    private final LoginService loginService;

    public LoginController(CustomerService customerService, LoginService loginService) {
        this.customerService = customerService;
        this.loginService = loginService;
    }

    @GetMapping("/{id}")
    public Role findbyId(@PathVariable("id") String id){
        Role roleUser = customerService.findById(id).getRole();
        loginService.setRole(roleUser);
        return roleUser;
    }

}
