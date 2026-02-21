package com.carRental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carRental.dto.ApiResponse;
import com.carRental.dto.BookingRequestDTO;
import com.carRental.dto.BookingResponseDTO;
import com.carRental.service.BookingService;

// Controller to manage car bookings and their statuses
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking request
    @PostMapping
    public ResponseEntity<ApiResponse<BookingResponseDTO>> createBooking(
            @RequestBody BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO createdBooking = bookingService.createBooking(bookingRequestDTO);
        return ResponseEntity
                .ok(new ApiResponse<>("Booking created successfully", true, createdBooking));
    }

    // API to fetch booking details by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookingResponseDTO>> getBookingById(
            @PathVariable Long id) {
        BookingResponseDTO booking = bookingService.getBookingById(id);
        if (booking != null) {
            return ResponseEntity.ok(new ApiResponse<>("Booking found", true, booking));
        }
        return ResponseEntity.status(404).body(new ApiResponse<>("Booking not found", false, null));
    }

    // Admin: Fetch all bookings across the system
    @GetMapping
    public ResponseEntity<ApiResponse<List<BookingResponseDTO>>> getAllBookings() {
        List<BookingResponseDTO> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(new ApiResponse<>("All bookings retrieved", true, bookings));
    }

    // Customer: Get list of bookings for the currently logged-in user
    @GetMapping("/my-bookings")
    public ResponseEntity<ApiResponse<List<BookingResponseDTO>>> getBookingsForLoggedInUser() {
        List<BookingResponseDTO> bookings = bookingService.getBookingsForLoggedInUser();
        return ResponseEntity.ok(new ApiResponse<>("Your bookings retrieved", true, bookings));
    }

    // Admin: Update the status of a booking (e.g., Approve/Reject)
    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<ApiResponse<BookingResponseDTO>> updateBookingStatus(
            @PathVariable Long id, @PathVariable String status) {
        BookingResponseDTO updatedBooking = bookingService.updateBookingStatus(id, status);
        if (updatedBooking != null) {
            return ResponseEntity
                    .ok(new ApiResponse<>("Booking status updated", true, updatedBooking));
        }
        return ResponseEntity.badRequest()
                .body(new ApiResponse<>("Failed to update status", false, null));
    }

    // Cancel an existing booking
    @PutMapping("/{id}/cancel")
    public ResponseEntity<ApiResponse<BookingResponseDTO>> cancelBooking(
            @PathVariable Long id) {
        BookingResponseDTO canceledBooking = bookingService.cancelBooking(id);
        if (canceledBooking != null) {
            return ResponseEntity
                    .ok(new ApiResponse<>("Booking cancelled successfully", true, canceledBooking));
        }
        return ResponseEntity.badRequest()
                .body(new ApiResponse<>("Failed to cancel booking", false, null));
    }
}
