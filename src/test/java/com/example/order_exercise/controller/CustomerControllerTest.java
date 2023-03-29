package com.example.order_exercise.controller;

import com.example.order_exercise.domain.Customer;
import com.example.order_exercise.dto.CreateCustomerDTO;
import com.example.order_exercise.dto.CustomerDTO;
import com.example.order_exercise.exceptions.IdNotFoundException;
import com.example.order_exercise.exceptions.MemberNotUniqueException;
import com.example.order_exercise.mapper.CustomerMapper;
import com.example.order_exercise.repository.CustomerRepository;
import com.example.order_exercise.security.Role;
import com.example.order_exercise.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

    private CustomerController controller;

    @BeforeEach
    void setUp(){
        controller = new CustomerController(new CustomerService(new CustomerRepository(), new CustomerMapper()));
    }

    @Test
    @DisplayName("Did we find all customers?")
    void findCustomers(){
        List<CustomerDTO> answer = controller.findAll();
        assertThat(answer).hasSize(2);
    }

    @Test
    @DisplayName("Dic I find member by ID?")
    void findMember(){
        CustomerDTO answer = controller.findbyId("dummy00@mail.com");

        assertThat(answer.getFirstname()).isEqualTo("du");

    }

    @Test
    @DisplayName("Is error thrown when existing mail given?")
    public void testWrongID() {
        CreateCustomerDTO customerTest = new CreateCustomerDTO("du", "mmy", "dummy00@mail.com","","","","","", Role.CUSTOMER);

        Throwable exception = assertThrows(MemberNotUniqueException.class, () ->
                controller.create(customerTest));
        assertEquals("Email not unique. Member already exists.", exception.getMessage());
    }

}