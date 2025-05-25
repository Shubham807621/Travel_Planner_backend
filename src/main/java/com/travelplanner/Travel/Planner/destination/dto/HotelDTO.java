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
public class HotelDTO {

    private UUID id;
    private String name;
    private String description;
    private String address;
    private double rating;
    private String imgUrl;
    private List<RoomDTO> rooms;
    private List<ReviewDTO> reviews;
}
