package com.travelplanner.Travel.Planner.destination.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelplanner.Travel.Planner.auth.entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonIgnore
    private Users user;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

    private Integer rating; // e.g., 1 to 5

    private String comment;

    private LocalDate createdAt;
}
