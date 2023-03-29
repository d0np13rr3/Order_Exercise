package com.example.order_exercise.repository;

import com.example.order_exercise.security.Role;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    private Enum roleUser = Role.CUSTOMER;

    public void setEnum(Enum role){
        roleUser = role;
    }

}
