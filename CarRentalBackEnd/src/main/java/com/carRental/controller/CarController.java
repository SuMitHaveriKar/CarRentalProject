package com.carRental.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carRental.dto.ApiResponse;
import com.carRental.dto.CarDTO;
import com.carRental.service.CarService;

import lombok.RequiredArgsConstructor;

// Controller for managing car inventory, search, and details
@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

        private final CarService carService;

        // Admin Only: Add a new car with its image to the database
        @PostMapping(consumes = { "multipart/form-data" })
        public ResponseEntity<ApiResponse<CarDTO>> addCar(
                        @ModelAttribute CarDTO carDTO,
                        @RequestParam(value = "imageFile", required = false) org.springframework.web.multipart.MultipartFile imageFile)
                        throws java.io.IOException {

                if (imageFile != null && !imageFile.isEmpty()) {
                        carDTO.setImage(imageFile.getBytes()); // Convert image to bytes for DB storage
                }

                CarDTO createdCar = carService.addCar(carDTO);

                return ResponseEntity.ok(
                                new ApiResponse<>("Car added successfully", true, createdCar));
        }

        // Get a list of all available cars for browsing
        @GetMapping
        public ResponseEntity<ApiResponse<List<CarDTO>>> getAllCars() {

                List<CarDTO> cars = carService.getAllCars();

                return ResponseEntity.ok(
                                new ApiResponse<>("All cars retrieved", true, cars));
        }

        // Fetch unique cities to populate the search dropdown
        @GetMapping("/cities")
        public ResponseEntity<ApiResponse<List<String>>> getUniqueCities() {
                List<String> cities = carService.getAllCars()
                                .stream()
                                .map(CarDTO::getCity)
                                .distinct()
                                .collect(java.util.stream.Collectors.toList());

                return ResponseEntity.ok(
                                new ApiResponse<>("Unique cities retrieved", true, cities));
        }

        // Retrieve detailed information for a specific car by ID
        @GetMapping("/{carId}")
        public ResponseEntity<ApiResponse<CarDTO>> getCarById(
                        @PathVariable Long carId) {

                CarDTO car = carService.getCarById(carId);

                return ResponseEntity.ok(
                                new ApiResponse<>("Car found", true, car));
        }

        // Search for cars based on location and date availability
        @GetMapping("/search")
        public ResponseEntity<ApiResponse<List<CarDTO>>> searchCars(
                        @RequestParam(required = false) String location,
                        @RequestParam(required = false) java.time.LocalDate pickupDate,
                        @RequestParam(required = false) java.time.LocalDate dropDate) {

                if (pickupDate == null || dropDate == null) {
                        // If no dates are selected, filter just by location
                        if (location != null && !location.trim().isEmpty()) {
                                List<CarDTO> allCars = carService.getAllCars();
                                String locLower = location.toLowerCase();
                                allCars = allCars.stream()
                                                .filter(c -> (c.getCity() != null
                                                                && c.getCity().toLowerCase().contains(locLower)) ||
                                                                (c.getPickupAddress() != null
                                                                                && c.getPickupAddress().toLowerCase()
                                                                                                .contains(locLower)))
                                                .collect(java.util.stream.Collectors.toList());
                                return ResponseEntity.ok(new ApiResponse<>("Cars retrieved", true, allCars));
                        }
                        return getAllCars();
                }

                // Filter cars that are available during the requested dates
                List<CarDTO> cars = carService.searchAvailableCars(location, pickupDate, dropDate);
                return ResponseEntity.ok(new ApiResponse<>("Available cars found", true, cars));
        }

        // Admin Only: Remove a car from the fleet
        @DeleteMapping("/{carId}")
        public ResponseEntity<ApiResponse<Void>> deleteCar(@PathVariable Long carId) {
                try {
                        System.out.println("Processing delete request for Car ID: " + carId);
                        carService.deleteCar(carId);
                        return ResponseEntity.ok(
                                        new ApiResponse<>("Car deleted successfully", true, null));
                } catch (Exception e) {
                        System.err.println("Error deleting car: " + e.getMessage());
                        return ResponseEntity.status(500).body(
                                        new ApiResponse<>("Error: " + e.getMessage(), false, null));
                }
        }
}
