package com.travelplanner.Travel.Planner.travelpackages.dto;

import com.travelplanner.Travel.Planner.destination.dto.HotelDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelPackageDetailsDTO {

    private UUID id;
    private String packageName;
    private boolean groupPackage;
    private double price;
    private int durationInDays;
    private String cityName;
    private List<PackageHotelDto> hotels;
    private List<ActivityDto> activities;
}
