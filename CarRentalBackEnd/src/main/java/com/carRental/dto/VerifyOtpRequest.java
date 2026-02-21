package com.carRental.dto;

import lombok.Data;

// Request object for verifying the One-Time Password
@Data
public class VerifyOtpRequest {
    private String email;
    private String otp;
}
