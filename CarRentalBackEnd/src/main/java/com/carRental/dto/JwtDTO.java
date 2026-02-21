package com.carRental.dto;

import com.carRental.entity.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// Helper object to hold user details extracted from a JWT token
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtDTO {

    private Long userId;
    private String email;
    private Role role;
}
