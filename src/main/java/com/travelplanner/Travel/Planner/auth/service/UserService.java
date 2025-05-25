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
        Users existing = userRepo.findByEmail(registrationRequest.getEmail());

        if(null != existing){
            return ResponseDto.builder()
                    .code(400)
                    .message("Email Already Exist !!")
                    .build();
        }

        // Fetch role from DB
        String roleCode = (registrationRequest.getRoleCode() == null || registrationRequest.getRoleCode().isEmpty())
                ? "USER"
                : registrationRequest.getRoleCode().toUpperCase();

        // Fetch role from DB
        Authority authority = authorityRepo.findByRoleCode(roleCode);
        if (authority == null) {
            return ResponseDto.builder()
                    .code(400)
                    .message("Invalid role provided")
                    .build();
        }

        // Generate userId based on role
        String generatedUserId = userHelper.generateUserId(authority.getRoleCode());

        Users user = Users.builder()
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .phoneNumber(registrationRequest.getPhoneNumber())
                .authority(authority)
                .enabled(true) // Optional: set to false if you want to verify first
                .userId(generatedUserId)
                .build();

        // Save
        userRepo.save(user);

        return  ResponseDto.builder()
                .code(201)
                .message("User registered successfully with ID: " + generatedUserId)
                .build();
    }
}
