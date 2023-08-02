package com.poly.quizapi.errors;

import org.springframework.http.HttpStatus;

public class CustomError extends RuntimeException {
    private String message;
    private HttpStatus statusCode;

    public CustomError(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
