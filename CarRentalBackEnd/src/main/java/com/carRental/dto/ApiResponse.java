package com.carRental.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Standard wrapper for all API responses to ensure consistent JSON structure
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    private String message;
    private boolean success;
    private T data;

    // Helper method to create a successful response with data
    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.<T>builder()
                .message(message)
                .success(true)
                .data(data)
                .build();
    }

    // Helper method to create a failure response with an error message
    public static <T> ApiResponse<T> failure(String message) {
        return ApiResponse.<T>builder()
                .message(message)
                .success(false)
                .build();
    }
}
