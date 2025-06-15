package com.travelplanner.Travel.Planner.booking.repo;

import com.travelplanner.Travel.Planner.booking.entity.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface HotelBookingRepo extends JpaRepository<HotelBooking, UUID> {
    List<HotelBooking> findByEndDateBeforeAndRoom_AvailableFalse(LocalDate today);
}
