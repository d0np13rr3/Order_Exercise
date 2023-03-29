package com.example.order_exercise.exceptions;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException() {
        super("Id not found. Try an existing id.");
    }
}
