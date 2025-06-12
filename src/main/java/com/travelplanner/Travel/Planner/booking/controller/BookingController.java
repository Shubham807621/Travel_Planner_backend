package com.travelplanner.Travel.Planner.booking.controller;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.booking.dto.HotelBookingDto;
import com.travelplanner.Travel.Planner.booking.entity.HotelBooking;
import com.travelplanner.Travel.Planner.booking.entity.PackageBooking;
import com.travelplanner.Travel.Planner.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/hotel-booking/{id}")
    public ResponseEntity<HotelBookingDto> getHotelBookingById(@PathVariable UUID id){

        HotelBookingDto hotelBooking = bookingService.getHotelBookingById(id);

        return new ResponseEntity<>(hotelBooking, HttpStatus.OK);
    }

//    @PostMapping("/add-hotel-booking")
//    public ResponseEntity<ResponseDto> addHotelBooking(@RequestBody HotelBookingDto hotelBookingDto){
//
//        ResponseDto responseDto = bookingService.addHotelBooking(hotelBookingDto);
//
//        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
//    }
}
