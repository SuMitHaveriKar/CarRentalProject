package com.carRental.dto;

import lombok.Data;

@Data
// Request object for initiating password recovery
@Data
public class ForgotPasswordRequest {
    private String email;
}
