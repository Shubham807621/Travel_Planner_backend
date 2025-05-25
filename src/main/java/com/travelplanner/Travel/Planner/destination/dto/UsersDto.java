package com.travelplanner.Travel.Planner.destination.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String userId;
    private String email;


}
