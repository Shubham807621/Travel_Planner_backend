package com.travelplanner.Travel.Planner.destination.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponseDto {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String imgUrl;
    private Double rating;
    private String cityName;
}
