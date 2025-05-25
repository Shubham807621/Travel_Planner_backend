package com.travelplanner.Travel.Planner.booking.repo;

import com.travelplanner.Travel.Planner.booking.entity.PackageBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingRepo extends JpaRepository<PackageBooking, UUID> {
}
