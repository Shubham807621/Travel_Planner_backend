package com.travelplanner.Travel.Planner.booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "package_item")
public class PackageItem {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PackageItemType type; // HOTEL, ACTIVITY, TRANSPORT

    private String itemName;

    private String description;

    private Double cost;

    @ManyToOne
    @JoinColumn(name = "package_booking_id")
    @JsonIgnore
    private PackageBooking packageBooking;
}
