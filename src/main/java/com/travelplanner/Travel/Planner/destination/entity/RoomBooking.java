package com.travelplanner.Travel.Planner.destination.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "room_booking")
public class RoomBooking {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

//    private Integer numberOfGuests;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
