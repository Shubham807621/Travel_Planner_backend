package com.travelplanner.Travel.Planner.booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelplanner.Travel.Planner.auth.entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "package_booking")
public class PackageBooking {

    @Id
    @GeneratedValue
    private UUID id;

    private String packageName;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer totalGuests;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingType bookingType; // SOLO or GROUP

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonIgnore
    private Users bookedBy;

    @OneToMany(mappedBy = "packageBooking", cascade = CascadeType.ALL)
    private List<Participant> participants;

    @OneToMany(mappedBy = "packageBooking", cascade = CascadeType.ALL)
    private List<PackageItem> packageItems;
}
