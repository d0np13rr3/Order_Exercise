package com.example.order_exercise.repository;

import com.example.order_exercise.security.Role;
import com.example.order_exercise.service.LoginService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ItemRepositoryTest {
    @LocalServerPort
    private int port;

    @Autowired
    private LoginService loginService;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("After deletion of items will I find nothing?")
    void itemApocalypse(){
        loginService.setRole(Role.ADMIN);

        itemRepository.deleteItemsInItemRepository();

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .port(port)
                .get("/items/0")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());

    }


}