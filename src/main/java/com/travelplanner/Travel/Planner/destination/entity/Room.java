package com.travelplanner.Travel.Planner.destination.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
@Builder
public class Room {

    @Id
    @GeneratedValue
    private UUID id;

    private String roomType; // e.g., "Deluxe", "Suite"

    private Integer capacity;

    private String roomSize;

    private String view;

    private String bedType;

    private Double pricePerNight;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;
}
