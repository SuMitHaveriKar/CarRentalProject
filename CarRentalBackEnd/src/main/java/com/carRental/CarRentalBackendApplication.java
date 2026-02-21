package com.carRental;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// The entry point for the Car Rental backend application.
// This class bootstraps the Spring Boot application.
@SpringBootApplication
public class CarRentalBackendApplication {

	// Launches the application using Spring Boot's SpringApplication.run().
	public static void main(String[] args) {
		SpringApplication.run(CarRentalBackendApplication.class, args);
	}

	// Configures the ModelMapper bean for strict object mapping.
	// This helps in converting DTOs to Entities and vice-versa efficiently.
	@Bean
	ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration()
				.setPropertyCondition(Conditions.isNotNull())
				.setMatchingStrategy(MatchingStrategies.STRICT);

		return mapper;
	}

	// Defines the BCryptPasswordEncoder bean for secure password hashing.
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
