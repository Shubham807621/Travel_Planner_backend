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
public class RoomDTO {

    private UUID id;
    private String roomType;
    private int capacity;
    private double pricePerNight;
}
