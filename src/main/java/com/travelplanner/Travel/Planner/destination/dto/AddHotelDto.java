package com.travelplanner.Travel.Planner.destination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddHotelDto {
    private UUID id;
    private String name;
    private String description;
    private double rating;
    private String imgUrl;
    private String address;
}
