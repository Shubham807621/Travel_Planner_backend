package com.travelplanner.Travel.Planner.booking.mapper;

import com.travelplanner.Travel.Planner.booking.dto.HotelBookingDto;
import com.travelplanner.Travel.Planner.booking.entity.HotelBooking;
import org.springframework.stereotype.Component;

@Component
public class HotelDtoMapper {

    public HotelBookingDto toDto(HotelBooking hotelBooking){

        String name = hotelBooking.getBookedBy().getFirstName()+ " " + hotelBooking.getBookedBy().getLastName();
        return HotelBookingDto.builder()
                .id(hotelBooking.getId())
                .hotelName(hotelBooking.getHotelName())
                .startDate(hotelBooking.getStartDate())
                .endDate(hotelBooking.getEndDate())
                .totalPrice(hotelBooking.getTotalPrice())
                .stateName(hotelBooking.getStateName())
                .cityName(hotelBooking.getCityName())
                .postalCode(hotelBooking.getPostalCode())
                .name(name)
                .email(hotelBooking.getBookedBy().getEmail())
                .build();
    }
}
