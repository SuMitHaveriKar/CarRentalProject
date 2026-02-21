package com.carRental.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carRental.entity.Role;
import com.carRental.entity.User;

// Repository for User management and authentication
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by their email address (used for login)
    Optional<User> findByEmail(String email);

    // Find users with a specific role who are not yet active (e.g., pending admins)
    List<User> findByRoleAndActiveFalse(Role role);
}
