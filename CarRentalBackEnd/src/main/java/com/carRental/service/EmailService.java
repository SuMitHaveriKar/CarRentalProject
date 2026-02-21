package com.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// Service for sending email notifications (e.g., OTPs)
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Sends an email containing the OTP for password reset
    public void sendOtpEmail(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Your QuickDrive Password Reset OTP"); // Updated name to QuickDrive
        message.setText("Hello,\n\nYour OTP for resetting your password is: " + otp +
                "\n\nThis OTP is valid for 5 minutes. Do not share it with anyone.\n\nBest regards,\nQuickDrive Team");
        mailSender.send(message);
    }
}
