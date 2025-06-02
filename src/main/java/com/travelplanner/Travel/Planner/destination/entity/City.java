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
@Table(name = "city")
@Builder
public class City {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "states_id")
    @JsonIgnore
    private States states;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    private List<Places> places ;
}
