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
public class ActivityDto {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private boolean isOutdoor;
}
