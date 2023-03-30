package com.example.order_exercise.dto;

import com.example.order_exercise.security.Role;

import java.util.Objects;

public class UserDTO {
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
    public UserDTO(String firstname, String lastname, String mail, String phone, String number, String street, String city, String postcode, Role role) {

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
    public String getFirstname() {
        return firstname;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO that = (UserDTO) o;
        return mail.equals(that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}
