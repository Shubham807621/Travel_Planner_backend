package com.travelplanner.Travel.Planner.destination.service;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.entity.Room;
import com.travelplanner.Travel.Planner.destination.entity.RoomBooking;
import com.travelplanner.Travel.Planner.destination.repo.BookingRepository;
import com.travelplanner.Travel.Planner.destination.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class RoomBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepo roomRepo;

    public boolean isRoomAvailable(UUID roomId, LocalDate checkIn, LocalDate checkOut) {
        List<RoomBooking> conflicts = bookingRepository.findConflictingRoomBookings(roomId, checkIn, checkOut);
        return conflicts.isEmpty();
    }
    public ResponseDto  createBooking(UUID roomId, LocalDate checkIn, LocalDate checkOut) {
        if (!isRoomAvailable(roomId, checkIn, checkOut)) {
            throw new RuntimeException("Room is not available for the selected dates");
        }

        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        RoomBooking booking = RoomBooking.builder()
                .room(room)
                .checkInDate(checkIn)
                .checkOutDate(checkOut)
                .build();

        bookingRepository.save(booking);
        return ResponseDto.builder().code(201).message("Dates Updated Successfully ").build();
    }
}
