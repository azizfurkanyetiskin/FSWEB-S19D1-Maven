package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlantException.class)
    public ResponseEntity<ErrorResponse> handlePlantException(PlantException ex) {

        log.error("PlantException: {}", ex.getMessage());

        ErrorResponse response = new ErrorResponse(
                ex.getHttpStatus().value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, ex.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getDefaultMessage())
                .orElse("Invalid data");

        log.error("Validation error: {}", message);

        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        message,
                        System.currentTimeMillis()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(
            HttpMessageNotReadableException ex) {

        log.error("Invalid request: {}", ex.getMessage());

        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        "Invalid request",
                        System.currentTimeMillis()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {

        log.error("Unexpected error", ex);

        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Unexpected server error",
                        System.currentTimeMillis()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}