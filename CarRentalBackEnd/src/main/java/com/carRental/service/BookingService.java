package com.carRental.service;

import java.util.List;

import com.carRental.dto.BookingRequestDTO;
import com.carRental.dto.BookingResponseDTO;
import com.carRental.dto.BookingStatusDTO;

// Service interface for managing car bookings
public interface BookingService {

    // Creates a new booking
    BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO);

    // Retrieves booking details by ID
    BookingResponseDTO getBookingById(Long id);

    // Retrieves all bookings (Admin only)
    List<BookingResponseDTO> getAllBookings();

    // Retrieves bookings for a specific customer
    List<BookingResponseDTO> getBookingsByCustomer(Long customerId);

    // Retrieves bookings for the currently logged-in user
    List<BookingResponseDTO> getBookingsForLoggedInUser();

    // Gets the current status of a booking
    BookingStatusDTO getBookingStatus(Long bookingId);

    // Updates the status of a booking (e.g., CONFIRMED, CANCELLED)
    BookingResponseDTO updateBookingStatus(Long bookingId, String status);

    // Cancels an existing booking
    BookingResponseDTO cancelBooking(Long bookingId);
}
