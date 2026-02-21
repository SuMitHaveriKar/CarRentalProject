package com.carRental.dto;

import com.carRental.entity.BookingStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Data transfer object for updating the status of a booking
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingStatusDTO {

    private Long bookingId;
    private BookingStatus bookingStatus;
}
