package com.example.order_exercise.controller;

import com.example.order_exercise.domain.User;
import com.example.order_exercise.dto.CreateUserDTO;
import com.example.order_exercise.dto.UserDTO;
import com.example.order_exercise.exceptions.MemberNotUniqueException;
import com.example.order_exercise.mapper.UserMapper;
import com.example.order_exercise.repository.LoginRepository;
import com.example.order_exercise.repository.UserRepository;
import com.example.order_exercise.security.Role;
import com.example.order_exercise.service.LoginService;
import com.example.order_exercise.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class UserControllerTest {


    private UserController controller;

    private LoginRepository loginRepository = new LoginRepository();

    private LoginService loginService = new LoginService(loginRepository);


    @BeforeEach
    void setUp(){
        controller = new UserController(new UserService(new UserRepository(), new UserMapper()), loginService);
    }
    @Test
    @DisplayName("Did we find all customers?")
    void findCustomers(){
        loginService.setRole(Role.ADMIN);
        List<UserDTO> answer = controller.findAll();
        assertThat(answer).hasSize(2);
    }
    @Test
    @DisplayName("Dic I find member by ID?")
    void findMember(){
        loginService.setRole(Role.ADMIN);
        UserDTO answer = controller.findbyId("dummy00@mail.com");
        assertThat(answer.getFirstname()).isEqualTo("du");
    }

    @Test
    @DisplayName("Is error thrown when existing mail given?")
    public void testWrongID() {
        loginService.setRole(Role.ADMIN);
        CreateUserDTO customerTest = new CreateUserDTO("du", "mmy", "dummy00@mail.com","","","","","", Role.CUSTOMER);
        Throwable exception = assertThrows(MemberNotUniqueException.class, () ->
                controller.create(customerTest));
        assertEquals("Email not unique. Member already exists.", exception.getMessage());
    }

}