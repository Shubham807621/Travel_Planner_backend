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
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue
    private UUID id;

    private String fullName;

    private String email;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "package_booking_id")
    @JsonIgnore
    private PackageBooking packageBooking;
}
