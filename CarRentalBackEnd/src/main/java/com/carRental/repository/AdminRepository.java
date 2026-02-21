package com.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carRental.entity.Admin;

// Repository for managing Admin entities (DB operations)
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
