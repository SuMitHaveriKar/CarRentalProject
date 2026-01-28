package com.carRental.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.carRental.dto.PaymentDTO;
import com.carRental.dto.PaymentOrderDTO;
import com.carRental.entity.Payment;
import com.carRental.entity.PaymentStatus;
import com.carRental.repository.BookingRepository;
import com.carRental.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final RazorpayService razorpayService;

    @Override
    public PaymentDTO makePayment(PaymentOrderDTO paymentOrderDTO) {
        Payment payment = modelMapper.map(paymentOrderDTO, Payment.class);
        if (paymentOrderDTO.getBookingId() != null) {
            payment.setBooking(bookingRepository.findById(Long.valueOf(paymentOrderDTO.getBookingId()))
                    .orElseThrow(() -> new RuntimeException("Booking not found")));
        }

        if (paymentOrderDTO.getRazorpayPaymentId() != null) {
            boolean isVerified = razorpayService.verifySignature(
                    paymentOrderDTO.getRazorpayOrderId(),
                    paymentOrderDTO.getRazorpayPaymentId(),
                    paymentOrderDTO.getRazorpaySignature());

            if (!isVerified) {
                throw new RuntimeException("Payment verification failed");
            }
            payment.setRazorpayPaymentId(paymentOrderDTO.getRazorpayPaymentId());
            payment.setRazorpayOrderId(paymentOrderDTO.getRazorpayOrderId());
            payment.setPaymentStatus(PaymentStatus.SUCCESS);
        } else if (payment.getPaymentStatus() == null) {
            payment.setPaymentStatus(PaymentStatus.SUCCESS); // Fallback for non-razorpay (if any) or existing logic
        }
        Payment savedPayment = paymentRepository.save(payment);
        return modelMapper.map(savedPayment, PaymentDTO.class);
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment == null)
            return null;
        return modelMapper.map(payment, PaymentDTO.class);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO getPaymentByBookingId(Long bookingId) {
        Payment payment = paymentRepository.findByBooking_BookingId(bookingId).orElse(null);
        if (payment == null)
            return null;
        return modelMapper.map(payment, PaymentDTO.class);
    }
}
