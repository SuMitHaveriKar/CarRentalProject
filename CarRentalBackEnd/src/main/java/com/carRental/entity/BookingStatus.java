package com.carRental.entity;

// Enum to track the lifecycle of a booking
public enum BookingStatus {
    PENDING, // Booking created but not yet approved or paid
    PAID, // Payment completed successfully
    CONFIRMED, // Booking officially approved providing the car
    REJECTED, // Booking denied by admin
    CANCELLED // Booking cancelled by user or admin
}
