package com.travelplanner.Travel.Planner.destination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StateDTO {
    private UUID id;
    private String name;
    private String description;
//    private List<CityDTO> cities;
}
