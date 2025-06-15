package com.travelplanner.Travel.Planner.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelBookingDto {
    private UUID id;
    private String hotelName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;
    private String stateName;
    private String cityName;
    private String postalCode;
    private String name;
    private String email;
    private UUID roomId;
}
