package com.carRental.service;

import java.util.List;

import com.carRental.dto.CarDTO;
import com.carRental.entity.CarStatus;
import com.carRental.entity.CarType;
import com.carRental.entity.FuelType;

// Service interface for managing car inventory
public interface CarService {

    // Adds a new car to the fleet
    CarDTO addCar(CarDTO carDTO);

    // Retrieves all cars in the system
    List<CarDTO> getAllCars();

    // Retrieves cars based on their current status (e.g., AVAILABLE)
    List<CarDTO> getCarsByStatus(CarStatus status);

    // Retrieves details of a specific car by ID
    CarDTO getCarById(Long id);

    // Searches cars by fuel type (Petrol, Diesel, etc.)
    List<CarDTO> searchCarsByFuelType(FuelType fuelType);

    // Searches cars by body type (SUV, Sedan, etc.)
    List<CarDTO> searchCarsByCarType(CarType carType);

    // Finds cars available for booking in a specific city and date range
    List<CarDTO> searchAvailableCars(String city, java.time.LocalDate pickupDate, java.time.LocalDate dropDate);

    // Removes a car from the system
    void deleteCar(Long id);
}
