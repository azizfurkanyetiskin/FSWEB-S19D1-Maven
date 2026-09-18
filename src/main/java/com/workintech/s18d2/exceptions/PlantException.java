package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;

public class PlantException extends RuntimeException {

    private HttpStatus httpStatus;

    public PlantException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public PlantException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public PlantException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }
}