package com.example.order_exercise.mapper;

import com.example.order_exercise.domain.Customer;
import com.example.order_exercise.dto.CreateCustomerDTO;
import com.example.order_exercise.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(customer.getFirstname(), customer.getLastname(), customer.getMail(), customer.getPhone(), customer.getNumber(), customer.getStreet(), customer.getCity(), customer.getPostcode(), customer.getRole());
    }
    public Customer toDomain(CreateCustomerDTO customerDTO){
        return new Customer(customerDTO.getFirstname(), customerDTO.getLastname(), customerDTO.getMail(), customerDTO.getPhone(), customerDTO.getNumber(), customerDTO.getStreet(), customerDTO.getCity(), customerDTO.getPostcode(), customerDTO.getRole());

    }
}
