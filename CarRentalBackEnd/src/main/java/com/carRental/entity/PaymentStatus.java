package com.carRental.entity;

// Enum to track the status of a payment
public enum PaymentStatus {
    PENDING,
    CREATED, // Razorpay order successfully created
    SUCCESS, // Payment completed and verified
    FAILED // Payment transaction failed
}
