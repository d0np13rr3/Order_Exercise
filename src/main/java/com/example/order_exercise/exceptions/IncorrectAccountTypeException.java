package com.example.order_exercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectAccountTypeException extends RuntimeException {

    public IncorrectAccountTypeException() {
        super("Incorrect account type, choose Admin or Customer.");
    }
}
