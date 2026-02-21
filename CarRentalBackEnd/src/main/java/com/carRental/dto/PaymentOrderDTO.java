package com.carRental.dto;

import java.time.LocalDate;
import com.carRental.entity.PaymentMode;
import com.carRental.entity.PaymentStatus;
import lombok.Data;

// Data transfer object for processing a payment order with Razorpay details
@Data
public class PaymentOrderDTO {
    private Long bookingId;
    private Double amount;
    private PaymentMode paymentMode;
    private PaymentStatus status;
    private LocalDate paymentDate;
    private String transactionId;
    private String razorpayPaymentId;
    private String razorpayOrderId;
    private String razorpaySignature;
}
