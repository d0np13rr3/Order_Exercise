package com.example.order_exercise.controller;

import com.example.order_exercise.dto.ItemDTO;
import com.example.order_exercise.exceptions.IdNotFoundException;
import com.example.order_exercise.exceptions.InvalidCommandException;
import com.example.order_exercise.exceptions.UnknownUserException;
import com.example.order_exercise.mapper.ItemMapper;
import com.example.order_exercise.repository.ItemRepository;
import com.example.order_exercise.repository.LoginRepository;
import com.example.order_exercise.security.Role;
import com.example.order_exercise.service.ItemService;
import com.example.order_exercise.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ItemControllerTest {
    private ItemController controller;
    private LoginRepository loginRepository = new LoginRepository();
    private LoginService loginService = new LoginService(loginRepository);

    @BeforeEach
    void setUp(){
        controller = new ItemController(new ItemService(new ItemMapper(), new ItemRepository()), loginService);
    }

    @Test
    @DisplayName("Did we find all items?")
    void findItems(){
        loginService.setRole(Role.ADMIN);
        List<ItemDTO> answer = controller.findAll();
        assertThat(answer).hasSize(3);
    }


    @Test
    @DisplayName("Is error thrown when wrong id given?")
    public void testWrongID() {
        loginService.setRole(Role.ADMIN);
        Throwable exception = assertThrows(IdNotFoundException.class, () ->
            controller.findItemByID(5));
        assertEquals("Id not found. Try an existing id.", exception.getMessage());
    }





}