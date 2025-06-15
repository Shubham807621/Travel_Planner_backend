package com.travelplanner.Travel.Planner.booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelplanner.Travel.Planner.auth.entity.Users;
import com.travelplanner.Travel.Planner.destination.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "hotel_booking")
public class HotelBooking {


    @Id
    @GeneratedValue
    private UUID id;

    private String hotelName;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double totalPrice;

    private String stateName;

    private String cityName;

    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonIgnore
    private Users bookedBy;


}
