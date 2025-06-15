package com.travelplanner.Travel.Planner.booking.service;

import com.travelplanner.Travel.Planner.booking.entity.HotelBooking;
import com.travelplanner.Travel.Planner.booking.repo.HotelBookingRepo;
import com.travelplanner.Travel.Planner.destination.entity.Room;
import com.travelplanner.Travel.Planner.destination.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomAvailabilityScheduler {

    @Autowired
    private HotelBookingRepo hotelBookingRepo;

    @Autowired
    private RoomRepo roomRepo;

    @Scheduled(cron = "0 0 2 * * *") // Every day at 2 AM
    public void updateRoomAvailability() {
        LocalDate today = LocalDate.now();

        List<HotelBooking> completedBookings = hotelBookingRepo.findByEndDateBeforeAndRoom_AvailableFalse(today);

        for (HotelBooking booking : completedBookings) {
            Room room = booking.getRoom();
            if (!room.getAvailable()) {
                room.setAvailable(true);
                roomRepo.save(room);
            }
        }
    }
}
