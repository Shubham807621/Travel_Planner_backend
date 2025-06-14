package com.travelplanner.Travel.Planner.destination.entity;

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
@Table(name = "states")
@NoArgsConstructor
@Builder
public class States {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Lob
    private String description;

    private String imgUrl;

    @OneToMany(mappedBy = "states", cascade = CascadeType.ALL)
    private List<City> cities;

    @OneToMany(mappedBy = "states", cascade = CascadeType.ALL)
    private List<Resources> resources;
}
