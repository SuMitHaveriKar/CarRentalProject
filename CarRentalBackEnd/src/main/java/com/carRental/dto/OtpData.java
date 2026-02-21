package com.carRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
// Internal class to store OTP details temporarily
@Data
@AllArgsConstructor
public class OtpData {
    private String otp;
    private LocalDateTime expiryTime;
    private int attempts;
}
