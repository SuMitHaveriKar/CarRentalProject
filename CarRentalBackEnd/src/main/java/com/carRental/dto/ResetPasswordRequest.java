package com.carRental.dto;

import lombok.Data;

@Data
// Request object for resetting the password using OTP
@Data
public class ResetPasswordRequest {
    private String email;
    private String otp;
    private String newPassword;
}
