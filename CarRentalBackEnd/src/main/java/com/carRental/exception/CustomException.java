package com.carRental.exception;

// Custom exception class for handling specific application errors
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
