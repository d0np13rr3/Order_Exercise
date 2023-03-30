package com.example.order_exercise.domain;

import com.example.order_exercise.exceptions.EmailNotValidException;
import com.example.order_exercise.security.Role;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    //Variables
    private String firstname;
    private String lastname;
    private String mail;
    private String phone;
    private String number;

    private String street;
    private String city;
    private String postcode;
    private Role role;
    //Constructor
    public User(String firstname, String lastname, String mail, String phone, String number, String street, String city, String postcode) {
        this(firstname, lastname, mail, phone, number, street, city, postcode, Role.CUSTOMER);
    }
    public User(){
    }
    public User(String firstname, String lastname, String mail, String phone, String number, String street, String city, String postcode, Role role){
        checkEmail(mail);
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.phone = phone;
        this.number = number;
        this.street = street;
        this.city =  city;
        this.postcode = postcode;
        this.role = role;
    }

    //Methods
    private static final Pattern EMAIL_PATTERN
            = Pattern.compile("\\b[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9]{2,}\\b");
    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
    public final void checkEmail(String email) {
        if (!isValidEmail(email)) {
            throw new EmailNotValidException();
        }
        this.mail = email;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
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
    public User setRole(Role role) {
        this.role = role;
        return this;
    }
    public String getMail() {

        return mail;
    }



}
