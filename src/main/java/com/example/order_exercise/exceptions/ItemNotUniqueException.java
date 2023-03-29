package com.example.order_exercise.exceptions;

public class ItemNotUniqueException extends RuntimeException{

    public ItemNotUniqueException() {
        super("Item not unique. Item already exists.");
    }
}
