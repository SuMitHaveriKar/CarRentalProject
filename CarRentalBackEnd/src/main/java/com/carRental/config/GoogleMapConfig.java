package com.carRental.config;

import org.springframework.context.annotation.Configuration;

// Configuration class for Google Maps integration settings
@Configuration
public class GoogleMapConfig {
    // Placeholder for the Google Maps API key.
    // This will be injected from application.properties when the feature is
    // enabled.
    // @Value("${google.map.api.key}")
    private String apiKey;
}
