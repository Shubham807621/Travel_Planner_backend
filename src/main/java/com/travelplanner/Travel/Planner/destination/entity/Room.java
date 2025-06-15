package com.travelplanner.Travel.Planner.destination.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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

    @Column(name = "available")
    private Boolean available = true;  // Use Boolean, not boolean

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomBooking> bookings;
}
