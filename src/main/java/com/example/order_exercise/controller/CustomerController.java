package com.example.order_exercise.controller;

import com.example.order_exercise.dto.CreateCustomerDTO;
import com.example.order_exercise.dto.CustomerDTO;
import com.example.order_exercise.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustomerDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO findbyId(@PathVariable("id") String id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO create(@RequestBody CreateCustomerDTO newCustomer){
        return service.create(newCustomer);
    }

}
