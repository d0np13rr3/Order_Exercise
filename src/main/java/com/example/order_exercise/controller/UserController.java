package com.example.order_exercise.controller;

import com.example.order_exercise.dto.CreateUserDTO;
import com.example.order_exercise.dto.UserDTO;
import com.example.order_exercise.service.LoginService;
import com.example.order_exercise.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.order_exercise.security.Feature.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final LoginService loginService;

    public UserController(UserService service, LoginService loginService) {
        this.service = service;
        this.loginService = loginService;
    }

    @GetMapping("/findall")
    public List<UserDTO> findAll(){
        loginService.validateAction(loginService.getRole(), CUSTOMER_FINDALL);
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findbyId(@PathVariable("id") String id){
        loginService.validateAction(loginService.getRole(), CUSTOMER_FINDBYID);
        return service.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody CreateUserDTO newCustomer){
        loginService.validateAction(loginService.getRole(), CUSTOMER_CREATE);
        return service.create(newCustomer);
    }

}
