package com.example.order_exercise.repository;

import com.example.order_exercise.domain.Customer;
import com.example.order_exercise.exceptions.MemberNotUniqueException;
import com.example.order_exercise.security.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

import java.util.logging.FileHandler;
@Repository
public class CustomerRepository {
    //Variables
    private static final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    private final HashMap<String, Customer> repository = new HashMap<>();
    //Constructor
    public CustomerRepository(){
        this.repository.put("pieter@mail.com", putAdminMain());
        Customer dummyCustomer00 = new Customer("du", "mmy", "dummy00@mail.com","","","","","");
        Customer dummyCustomer01 = new Customer("du", "mmy", "dummy01@mail.com","","","","","");
        logger.warn("Dummy00 mail - only for debugging purposes "+ dummyCustomer00.getMail());
        logger.warn("Dummy00 mail - only for debugging purposes "+ dummyCustomer01.getMail());
        repository.put(dummyCustomer00.getMail(), dummyCustomer00);
        repository.put(dummyCustomer01.getMail(), dummyCustomer01);
    }
    //Methods
    private static Customer putAdminMain() {
        Customer admin = new Customer("Pieter", "Pauwels", "pieter.pauwels13@gmail.com", "",
                "", "", "", "Gent", Role.ADMIN); // cGlldGVyLnBhdXdlbHMxM0BnbWFpbC5jb206WFhY
        admin.setRole(Role.ADMIN);
        logger.warn("Admin mail - only for debugging purposes " + admin.getMail());
        return admin;
    }
    public Collection<Customer>findAll(){

        return repository.values();
    }
    public Customer create(Customer customer){
        checkIfEmailIsUnique(customer);
        repository.put(customer.getMail(), customer);
        return customer;
    }
    public Customer findByEmail(String mail){

        return repository.get(mail);
    }
    private void checkIfEmailIsUnique(Customer newCustomer) {
        if (this.repository.values().stream().map(Customer::getMail).anyMatch(email -> email.equals(newCustomer.getMail()))){
            throw new MemberNotUniqueException();
        }

    }


}
