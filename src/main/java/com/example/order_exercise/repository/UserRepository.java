package com.example.order_exercise.repository;

import com.example.order_exercise.domain.User;
import com.example.order_exercise.exceptions.MemberNotUniqueException;
import com.example.order_exercise.security.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

@Repository
public class UserRepository {
    //Variables
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private final HashMap<String, User> repository = new HashMap<>();
    //Constructor
    public UserRepository(){
        repository.put("pieter@mail.com", putAdminMain());
        User dummyCustomer00 = new User("du", "mmy", "dummy00@mail.com","","","","","");
        User dummyCustomer01 = new User("du", "mmy", "dummy01@mail.com","","","","","");
        logger.warn("Dummy00 mail - only for debugging purposes "+ dummyCustomer00.getMail());
        logger.warn("Dummy00 mail - only for debugging purposes "+ dummyCustomer01.getMail());
        repository.put(dummyCustomer00.getMail(), dummyCustomer00);
        repository.put(dummyCustomer01.getMail(), dummyCustomer01);
    }
    //Methods
    private static User putAdminMain() {
        User admin = new User("Pieter", "Pauwels", "pieter@mail.com", "",
                "", "", "", "Gent", Role.ADMIN);
        admin.setRole(Role.ADMIN);
        logger.warn("Admin mail - only for debugging purposes " + admin.getMail());
        return admin;
    }
    public Collection<User>findAll(){

        return repository.values();
    }
    public User create(User user){
        checkIfEmailIsUnique(user);
        repository.put(user.getMail(), user);
        return user;
    }
    public Optional<User> findByEmail(String mail){
        return Optional.ofNullable(repository.get(mail));
    }
    private void checkIfEmailIsUnique(User newCustomer) {
        if (this.repository.values().stream().map(User::getMail).anyMatch(email -> email.equals(newCustomer.getMail()))){
            throw new MemberNotUniqueException();
        }

    }


}
