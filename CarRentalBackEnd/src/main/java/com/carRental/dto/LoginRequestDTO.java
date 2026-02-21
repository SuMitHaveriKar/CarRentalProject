package com.carRental.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/// Data transfer object for user login credentials
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDTO {

    private String email;
    private String password;
}
