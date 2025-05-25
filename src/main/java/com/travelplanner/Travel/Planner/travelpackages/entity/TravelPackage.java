package com.travelplanner.Travel.Planner.travelpackages.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelplanner.Travel.Planner.destination.entity.City;
import com.travelplanner.Travel.Planner.destination.entity.Hotel;
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
@Table(name = "travelPackage")
@Builder
public class TravelPackage {

    @Id
    @GeneratedValue
    private UUID id;

    private String packageName;

    private boolean isGroupPackage; // false = solo, true = group

    private double price;

    private int durationInDays;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnore
    private City city;

    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
    private List<Hotel> hotels;


    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
    private List<Activity> activities;
}
