package com.carRental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carRental.entity.CarLocation;

// Repository for accessing CarLocation data
public interface CarLocationRepository extends JpaRepository<CarLocation, Long> {

    // Find location details by the Car entity
    Optional<CarLocation> findByCar(com.carRental.entity.Car car);

    // Find location details using the car's ID
    Optional<CarLocation> findByCar_CarId(Long carId);
}
