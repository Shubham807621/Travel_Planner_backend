package com.travelplanner.Travel.Planner.booking.service;

import com.travelplanner.Travel.Planner.booking.entity.PackageBooking;
import com.travelplanner.Travel.Planner.booking.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public PackageBooking getPackageBookingById(UUID id) {
        return bookingRepo.findById(id).orElse(null);
    }
}
