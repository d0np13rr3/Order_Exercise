package com.example.order_exercise.repository;

import com.example.order_exercise.security.Role;
import com.example.order_exercise.service.LoginService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.example.order_exercise.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserRepositoryTest {

    @LocalServerPort
    private int port;
    @Autowired
    private UserRepository repository;
    @Autowired
    private LoginService loginService;

    @Test
    @DisplayName("Rest assured - Test OK?")
    void willThisEvenWork(){
        loginService.setRole(Role.ADMIN);
        //GIVEN
        User dummyCustomer99 = new User("dum", "my", "dummy99@mail.com","","","","","");
        repository.create(dummyCustomer99);
        //WHEN
        User dummy = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .port(port)
                .get("/users/" + dummyCustomer99.getMail())
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.OK.value()) // status 200
                .extract()
                .as(User.class); // Get a contact from the system

        Assertions.assertThat(dummy).isEqualTo(dummyCustomer99);

    }

}