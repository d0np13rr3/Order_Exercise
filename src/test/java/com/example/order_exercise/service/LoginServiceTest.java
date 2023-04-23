package com.example.order_exercise.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

import com.example.order_exercise.repository.LoginRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginServiceTest {

    @Test
    @DisplayName("Is my repo accessed?")
    void testService(){
        //GIVEN
        LoginRepository repo = Mockito.mock(LoginRepository.class);
        LoginService service = new LoginService(repo);
        //WHEN
        service.getRole();
        //THEN
        Mockito.verify(repo).getRole();

    }

}