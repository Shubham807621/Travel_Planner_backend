package com.travelplanner.Travel.Planner.destination.repo;

import com.travelplanner.Travel.Planner.destination.entity.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<RoomBooking, UUID> {

    @Query("SELECT b FROM RoomBooking b WHERE b.room.id = :roomId AND " +
            "(:checkInDate < b.checkOutDate AND :checkOutDate > b.checkInDate)")
    List<RoomBooking> findConflictingRoomBookings(
            @Param("roomId") UUID roomId,
            @Param("checkInDate") LocalDate checkInDate,
            @Param("checkOutDate") LocalDate checkOutDate
    );
}
