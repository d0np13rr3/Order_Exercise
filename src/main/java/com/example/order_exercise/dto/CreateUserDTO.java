package com.example.order_exercise.dto;

import com.example.order_exercise.security.Role;

public class CreateUserDTO {
    //Variables
    private final String firstname;
    private final String lastname;
    private final String mail;
    private final String phone;
    private final String number;
    private final String street;
    private final String city;
    private final String postcode;
    private final Role role;
    //Constructor
    public CreateUserDTO(String firstname, String lastname, String mail, String phone, String number, String street, String city, String postcode, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.phone = phone;
        this.number = number;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.role = role;
    }
    //Methods
    public String getLastname() {
        return lastname;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public Role getRole() {
        return role;
    }

    public String getFirstname() {
        return firstname;
    }
}
