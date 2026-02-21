package com.carRental.service;

import com.carRental.dto.RegisterRequestDTO;
import com.carRental.dto.UserDTO;

// Service interface for authentication operations (Register, Login, Password Reset)
public interface AuthService {

    // Registers a new user (Customer or Admin)
    UserDTO register(RegisterRequestDTO registerRequestDTO);

    // Logs in a user and returns a JWT token
    com.carRental.dto.AuthResponseDTO login(com.carRental.dto.LoginRequestDTO loginRequestDTO);

    // Intiates password reset flow by sending an OTP
    void forgotPassword(String email);

    // Verifies if the provided OTP is valid
    boolean verifyOtp(String email, String otp);

    // Resets the user's password after successful OTP verification
    void resetPassword(String email, String otp, String newPassword);
}
