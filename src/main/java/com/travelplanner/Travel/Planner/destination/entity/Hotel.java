package com.travelplanner.Travel.Planner.destination.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelplanner.Travel.Planner.travelpackages.entity.TravelPackage;
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
@Table(name = "hotel")
@Builder
public class Hotel {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    private String address;

    private String imgUrl;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnore
    private City city;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms;

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "travelPackage_id")
    @JsonIgnore
    private TravelPackage travelPackage;
}
