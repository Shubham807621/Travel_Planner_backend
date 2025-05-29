package com.travelplanner.Travel.Planner.travelpackages.dto;

import com.travelplanner.Travel.Planner.destination.dto.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageHotelDto {
    private String name;
    private String address;
    private double rating;
    private List<RoomDTO> rooms;
}
