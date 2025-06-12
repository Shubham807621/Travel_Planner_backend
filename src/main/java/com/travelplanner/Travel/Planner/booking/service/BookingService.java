package com.travelplanner.Travel.Planner.booking.service;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.auth.entity.Users;
import com.travelplanner.Travel.Planner.auth.repo.UsersRepo;
import com.travelplanner.Travel.Planner.booking.dto.HotelBookingDto;
import com.travelplanner.Travel.Planner.booking.entity.HotelBooking;
import com.travelplanner.Travel.Planner.booking.entity.PackageBooking;
import com.travelplanner.Travel.Planner.booking.mapper.HotelDtoMapper;
import com.travelplanner.Travel.Planner.booking.repo.BookingRepo;
import com.travelplanner.Travel.Planner.booking.repo.HotelBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private HotelBookingRepo hotelBookingRepo;

    @Autowired
    private HotelDtoMapper hotelDtoMapper;

    @Autowired
    private UsersRepo usersRepo;

    public PackageBooking getPackageBookingById(UUID id) {
        return bookingRepo.findById(id).orElse(null);
    }

    public HotelBookingDto getHotelBookingById(UUID id) {

        HotelBooking hotelBooking= hotelBookingRepo.findById(id).orElse(null);

        return hotelDtoMapper.toDto(hotelBooking);
    }


}
