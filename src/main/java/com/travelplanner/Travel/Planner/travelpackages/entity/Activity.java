package com.travelplanner.Travel.Planner.travelpackages.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activity")
@Builder
public class Activity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean isOutdoor;

    @ManyToOne
    @JoinColumn(name = "travelPackage_id")
    @JsonIgnore
    private TravelPackage travelPackage;
}
