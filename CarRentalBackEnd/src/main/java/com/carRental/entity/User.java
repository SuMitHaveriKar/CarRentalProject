package com.carRental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;

// Base entity representing a user in the system
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // Determines permissions (ADMIN or CUSTOMER)

    @Column(unique = true)
    private String drivingLicence;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] drivingLicenceImage; // Stores license image directly in DB

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    /**
     * Indicates if the user account is active.
     * Customers are active by default.
     * Admins require approval from an existing admin.
     */
    @Column(nullable = false)
    @Builder.Default
    private boolean active = true;
}
