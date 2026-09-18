package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;

public class VegetableException extends PlantException {

    public VegetableException(String message) {
        super(message);
    }

    public VegetableException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}