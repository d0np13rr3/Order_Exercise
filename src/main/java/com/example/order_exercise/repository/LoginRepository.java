package com.example.order_exercise.repository;

import com.example.order_exercise.security.Role;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    private Role roleUser = Role.DEFAULT;

    public void setEnum(Role role){
        roleUser = role;
    }

    public Role getRole() {
        return roleUser;
    }
}
