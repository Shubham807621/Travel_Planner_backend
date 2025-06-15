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
import com.travelplanner.Travel.Planner.destination.entity.Room;
import com.travelplanner.Travel.Planner.destination.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Autowired
    private RoomRepo roomRepo;

    public PackageBooking getPackageBookingById(UUID id) {
        return bookingRepo.findById(id).orElse(null);
    }

    public HotelBookingDto getHotelBookingById(UUID id) {

        HotelBooking hotelBooking= hotelBookingRepo.findById(id).orElse(null);

        return hotelDtoMapper.toDto(hotelBooking);
    }


    public ResponseDto addHotelBooking(HotelBookingDto hotelBookingDto) {
        Users users = usersRepo.findByEmail(hotelBookingDto.getEmail());
        Room room = roomRepo.findById(hotelBookingDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // Set room as unavailable
        room.setAvailable(false);
        roomRepo.save(room); // Save the change

        HotelBooking hotelBooking = HotelBooking.builder()
                .hotelName(hotelBookingDto.getHotelName())
                .startDate(hotelBookingDto.getStartDate())
                .endDate(hotelBookingDto.getEndDate())
                .totalPrice(hotelBookingDto.getTotalPrice())
                .stateName(hotelBookingDto.getStateName())
                .cityName(hotelBookingDto.getCityName())
                .postalCode(hotelBookingDto.getPostalCode())
                .bookedBy(users)
                .room(room) // Optional: associate room with booking
                .build();

        hotelBookingRepo.save(hotelBooking);

        return ResponseDto.builder()
                .code(201)
                .message("Booking Completed")
                .build();
    }

    public List<HotelBookingDto> getAllBooking() {

        List<HotelBooking> hotelBooking = hotelBookingRepo.findAll();

        return hotelBooking.stream().map(hotelDtoMapper::toDto).collect(Collectors.toList());

    }
}
