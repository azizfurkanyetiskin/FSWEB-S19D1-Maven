package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;

public class FruitException extends PlantException {

    public FruitException(String message) {
        super(message);
    }

    public FruitException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}