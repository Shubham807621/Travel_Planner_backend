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
@Table(name = "resources")
@Builder
public class Resources {

    @Id
    @GeneratedValue
    private UUID id;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "states_id")
    @JsonIgnore
    private States states;
}
