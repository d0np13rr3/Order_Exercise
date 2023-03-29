package com.example.order_exercise.exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException() {
        super("Item not found. Try an existing item.");
    }
}
