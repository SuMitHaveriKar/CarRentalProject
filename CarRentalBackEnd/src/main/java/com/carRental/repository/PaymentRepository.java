package com.carRental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carRental.entity.Payment;

// Repository for Payment transaction data
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	// Retrieve payment details associated with a specific booking
	Optional<Payment> findByBooking_BookingId(Long bookingId);
}
