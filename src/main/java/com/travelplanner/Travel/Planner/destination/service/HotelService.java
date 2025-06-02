package com.travelplanner.Travel.Planner.destination.service;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.AddHotelDto;
import com.travelplanner.Travel.Planner.destination.dto.HotelDTO;
import com.travelplanner.Travel.Planner.destination.dto.HotelListDto;
import com.travelplanner.Travel.Planner.destination.entity.City;
import com.travelplanner.Travel.Planner.destination.entity.Hotel;
import com.travelplanner.Travel.Planner.destination.mapper.DtoMapper;
import com.travelplanner.Travel.Planner.destination.repo.CityRepo;
import com.travelplanner.Travel.Planner.destination.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private DtoMapper dtoMapper;


    public List<HotelListDto> getAllHotels(String name) {

        City city = cityRepo.findByName(name);

        List<Hotel> hotels = city.getHotels();

        return hotels.stream().map(dtoMapper::toHotelListDto).collect(Collectors.toList());

    }

    public HotelDTO getHotelById(UUID id) {

        Hotel hotel = hotelRepo.findById(id).orElse(null);

        assert hotel != null;
        return dtoMapper.toHotelDto(hotel);
    }

    public ResponseDto addHotel(AddHotelDto addHotelDto, String name) {

        Hotel existingHotel = hotelRepo.findByName(addHotelDto.getName());

        if (existingHotel != null){
            return ResponseDto.builder().code(400).message("Hotel already exists with name :" + existingHotel.getName()).build();
        }

        City city = cityRepo.findByName(name);

        Hotel hotel = Hotel.builder()
                .name(addHotelDto.getName())
                .description(addHotelDto.getDescription())
                .rating(addHotelDto.getRating())
                .imgUrl(addHotelDto.getImgUrl())
                .address(addHotelDto.getAddress())
                .city(city)
                .build();

        hotelRepo.save(hotel);

        return ResponseDto.builder().code(201).message("Hotel Added Successfully").build();
    }

    public ResponseDto updateHotel(AddHotelDto addHotelDto) {

        Hotel hotel = hotelRepo.findById(addHotelDto.getId()).orElse(null);

        if (hotel != null){
            hotel.setName(addHotelDto.getName());
            hotel.setDescription(addHotelDto.getDescription());
            hotel.setAddress(addHotelDto.getAddress());
            hotel.setImgUrl(addHotelDto.getImgUrl());
            hotel.setRating(addHotelDto.getRating());

            hotelRepo.save(hotel);
            return ResponseDto.builder().code(200).message("Hotel Details Updated Successfully").build();
        }
        return ResponseDto.builder().code(400).message("Hotel not exists ").build();

    }
}
