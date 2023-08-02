package com.poly.quizapi.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleError(CustomError error) {
        Map<?, ?> map = new HashMap<>(){{
            put("message", error.getMessage());
            put("status", error.getStatusCode().value());
        }};

        return new ResponseEntity<>(
                map,
                error.getStatusCode()
        );
    }
    @ExceptionHandler
    public ResponseEntity<?> handleUnknownError(Exception error) {
        Map<?, ?> map = new HashMap<>(){{
            put("message", error.getMessage());
            put("status", "400");
        }};

        return new ResponseEntity<>(
                map,
                HttpStatus.BAD_REQUEST
        );
    }
}
