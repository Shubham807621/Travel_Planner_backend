package com.travelplanner.Travel.Planner.booking.controller;

import com.travelplanner.Travel.Planner.booking.entity.PackageBooking;
import com.travelplanner.Travel.Planner.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/booking/{id}")
    public ResponseEntity<PackageBooking> getPackageBookingById(@PathVariable UUID id){

        PackageBooking packageBooking = bookingService.getPackageBookingById(id);

        return new ResponseEntity<>(packageBooking, HttpStatus.OK);
    }

}
