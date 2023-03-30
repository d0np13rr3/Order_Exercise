package com.example.order_exercise.service;

import com.example.order_exercise.domain.User;
import com.example.order_exercise.dto.CreateUserDTO;
import com.example.order_exercise.dto.UserDTO;
import com.example.order_exercise.exceptions.UnknownUserException;
import com.example.order_exercise.mapper.UserMapper;
import com.example.order_exercise.repository.UserRepository;
import com.example.order_exercise.security.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UserDTO> findAll() {
       return repository.findAll()
               .stream()
               .filter(x -> x.getRole().equals(Role.CUSTOMER))
               .map(mapper::toDTO)
               .toList();
    }

    public UserDTO findById(String id) {
        if(!repository.findByEmail(id).isPresent()){
            throw new UnknownUserException();
        }
        return mapper.toDTO(repository.findByEmail(id).get());
    }

    public UserDTO create(CreateUserDTO newCustomer) {
        User customerToSave = mapper.toDomain(newCustomer);
        return mapper.toDTO(repository.create(customerToSave));
    }
}
