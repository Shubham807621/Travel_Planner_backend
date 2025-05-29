package com.travelplanner.Travel.Planner.travelpackages.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackageRequestDto {
    private String packageName;
    private boolean groupPackage;
    private double price;
    private int durationInDays;
    private String cityName; // ⬅️ Pass city name instead of city ID
    private List<PackageHotelDto> hotels;
    private List<ActivityDto> activities;
}
