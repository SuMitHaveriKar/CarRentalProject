package com.carRental.service;

import java.util.List;
import com.carRental.dto.PaymentDTO;
import com.carRental.dto.PaymentOrderDTO;

// Service interface for processing payments
public interface PaymentService {

    // Processes a payment order and saves it
    PaymentDTO makePayment(PaymentOrderDTO paymentOrderDTO);

    // Retrieves payment details by ID
    PaymentDTO getPaymentById(Long id);

    // Retrieves all payment records
    List<PaymentDTO> getAllPayments();

    // Retrieves payment details specific to a booking
    PaymentDTO getPaymentByBookingId(Long bookingId);
}
