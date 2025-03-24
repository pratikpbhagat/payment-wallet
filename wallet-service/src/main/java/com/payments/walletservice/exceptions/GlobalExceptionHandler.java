package com.payments.walletservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle user exists exception
     *
     * @param e the user exists exception
     * @return the response entity
     */
    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<Map<String, Object>> handleUserExistsException(UserExistsException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
