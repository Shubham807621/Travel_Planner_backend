package com.travelplanner.Travel.Planner.travelpackages.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackageDto {
    private UUID id;
    private String packageName;
    private boolean isGroupPackage; // false = solo, true = group
    private double price;
    private int durationInDays;
}
