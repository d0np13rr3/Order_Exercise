package com.example.order_exercise.service;

import com.example.order_exercise.domain.Customer;
import com.example.order_exercise.exceptions.UnknownUserException;
import com.example.order_exercise.repository.CustomerRepository;
import com.example.order_exercise.repository.LoginRepository;
import com.example.order_exercise.security.Feature;
import com.example.order_exercise.security.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void validateAction(Customer customer, Feature feature){
        if(customer == null){
            logger.error("Unknonw user");
            throw new UnknownUserException();
        }


    }

    public void setRole(Role roleUser) {
        loginRepository.setEnum(roleUser);

    }
}
