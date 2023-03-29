package com.example.order_exercise.exceptions;

public class AmountNotCorrectException extends RuntimeException {

    public AmountNotCorrectException() {
        super("Amount not correct, use another value.");
    }
}
