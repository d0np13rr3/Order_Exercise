package com.example.order_exercise.mapper;

import com.example.order_exercise.domain.User;
import com.example.order_exercise.dto.CreateUserDTO;
import com.example.order_exercise.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User customer) {
        return new UserDTO(customer.getFirstname(), customer.getLastname(), customer.getMail(), customer.getPhone(), customer.getNumber(), customer.getStreet(), customer.getCity(), customer.getPostcode(), customer.getRole());
    }
    public User toDomain(CreateUserDTO customerDTO){
        return new User(customerDTO.getFirstname(), customerDTO.getLastname(), customerDTO.getMail(), customerDTO.getPhone(), customerDTO.getNumber(), customerDTO.getStreet(), customerDTO.getCity(), customerDTO.getPostcode(), customerDTO.getRole());

    }
}
