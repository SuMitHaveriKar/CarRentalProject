package com.carRental.service;

import com.carRental.entity.CarLocation;

// Service interface for managing car location details
public interface LocationService {

    // Sets the location for a specific car
    CarLocation addLocation(Long carId, CarLocation location);

    // Updates the existing location of a car
    CarLocation updateLocation(Long carId, CarLocation location);

    // Retrieves location details for a car
    CarLocation getLocationByCarId(Long carId);
}
