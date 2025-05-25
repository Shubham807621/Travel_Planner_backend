package com.travelplanner.Travel.Planner.destination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private UUID id;
    private int rating;
    private String comment;
    private LocalDate createdAt;
    private UsersDto user;
}
