package com.travelplanner.Travel.Planner.auth.service;


import com.travelplanner.Travel.Planner.auth.dto.RegistrationRequest;
import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.auth.entity.Authority;
import com.travelplanner.Travel.Planner.auth.entity.Users;
import com.travelplanner.Travel.Planner.auth.mapper.UserHelper;
import com.travelplanner.Travel.Planner.auth.repo.AuthorityRepo;
import com.travelplanner.Travel.Planner.auth.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepo userRepo;

    @Autowired
    private AuthorityRepo authorityRepo;

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseDto register(RegistrationRequest registrationRequest) {
        // Check for existing email
        Users existing = userRepo.findByEmail(registrationRequest.getEmail());
        if (existing != null) {
            return ResponseDto.builder()
                    .code(400)
                    .message("Email Already Exist !!")
                    .build();
        }

        // Use default role "User" if none provided
        String roleCode = registrationRequest.getRoleCode();
        if (roleCode == null || roleCode.trim().isEmpty()) {
            roleCode = "User";
        }

        // Fetch role from DB
        Authority authority = authorityRepo.findByRoleCode(roleCode);
        if (authority == null) {
            return ResponseDto.builder()
                    .code(400)
                    .message("Invalid role code")
                    .build();
        }

        // Assign role
        List<Authority> newAuthorities = new ArrayList<>();
        newAuthorities.add(authority);

        // Generate userId based on role
        String generatedUserId = userHelper.generateUserId(authority.getRoleCode());

        // Build and save user
        Users user = Users.builder()
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .phoneNumber(registrationRequest.getPhoneNumber())
                .authorities(newAuthorities)
                .enabled(true)
                .userId(generatedUserId)
                .build();

        userRepo.save(user);

        return ResponseDto.builder()
                .code(201)
                .message("User registered successfully with ID: " + generatedUserId)
                .build();
    }

}
