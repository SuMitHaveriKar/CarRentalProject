package com.carRental.config;

import org.springframework.context.annotation.Configuration;

// Configuration class for Razorpay payment gateway settings
@Configuration
public class RazorpayConfig {
    // Razorpay Key ID, injected from the application properties file.
    // @Value("${razorpay.key.id}")
    private String keyId;

    // Razorpay Key Secret, also injected from properties.
    // @Value("${razorpay.key.secret}")
    private String keySecret;
}
