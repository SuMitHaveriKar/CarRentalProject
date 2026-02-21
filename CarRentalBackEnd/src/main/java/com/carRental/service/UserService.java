package com.carRental.service;

import org.springframework.web.multipart.MultipartFile;
import com.carRental.dto.UserDTO;

// Service interface for user profile management
public interface UserService {

    // Uploads and updates the driving license image for a user
    UserDTO uploadLicenseImage(Long userId, MultipartFile file) throws Exception;
}
