package com.carRental.dto;

import com.carRental.entity.CarStatus;
import com.carRental.entity.CarType;
import com.carRental.entity.FuelType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Data transfer object representing a car in our fleet
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {

    private Long carId;
    private byte[] image; // Car image stored as byte array
    private String brand;
    private String model;
    private String registrationNumber;
    private String city; // Current location of the car
    private String pickupAddress;
    private String description;
    private Double pricePerDay;
    private Integer seatingCapacity;
    private FuelType fuelType; // PETROL, DIESEL, ELECTRIC, etc.
    private CarType carType; // SEDAN, SUV, HATCHBACK, etc.
    private String mapUrl; // Google Maps link for pickup location
    private CarStatus status; // AVAILABLE or BOOKED
}
