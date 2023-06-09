package com.example.order_exercise.service;

import com.example.order_exercise.exceptions.InvalidCommandException;
import com.example.order_exercise.exceptions.UnknownUserException;
import com.example.order_exercise.repository.UserRepository;
import com.example.order_exercise.repository.LoginRepository;
import com.example.order_exercise.security.Feature;
import com.example.order_exercise.security.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void validateAction(Role role, Feature feature){
        if(role == null){
            logger.error("Unknown user");
            throw new UnknownUserException();
        }
        if(!role.containsFeature(feature)){
            logger.error("Not a valid command");
            throw new InvalidCommandException();
        }else{
            logger.info("Valid command");
        }
    }

    public void setRole(Role roleUser) {
        loginRepository.setEnum(roleUser);
    }

    public Role getRole() {
        return loginRepository.getRole();
    }

    public void setName(String nameUser) {
        loginRepository.setName(nameUser);
    }
}
