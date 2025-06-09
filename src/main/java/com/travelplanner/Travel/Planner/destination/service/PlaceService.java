package com.travelplanner.Travel.Planner.destination.service;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.PlaceDto;
import com.travelplanner.Travel.Planner.destination.entity.City;
import com.travelplanner.Travel.Planner.destination.entity.Hotel;
import com.travelplanner.Travel.Planner.destination.entity.Places;
import com.travelplanner.Travel.Planner.destination.mapper.DtoMapper;
import com.travelplanner.Travel.Planner.destination.repo.CityRepo;
import com.travelplanner.Travel.Planner.destination.repo.HotelRepo;
import com.travelplanner.Travel.Planner.destination.repo.PlaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepo placeRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private DtoMapper dtoMapper;

    public List<Places> getAllPlaces() {
        return placeRepo.findAll();
    }


    public List<PlaceDto> getPlaceByCityName(String name) {
       City city = cityRepo.findByName(name);

       List<Places> places = city.getPlaces();

        return places.stream().map(dtoMapper::toPlaceDto).collect(Collectors.toList());
    }

    public ResponseDto addPlace(PlaceDto placeDto, String name) {
        Places existingPlace = placeRepo.findByName(placeDto.getName());
        if (existingPlace != null){
            return ResponseDto.builder().code(400).message("Hotel already exists with name :" + placeDto.getName()).build();
        }

        City city = cityRepo.findByName(name);

        Places places = Places.builder()
                .name(placeDto.getName())
                .description(placeDto.getDescription())
                .imgUrl(placeDto.getImgUrl())
                .city(city)
                .build();

        placeRepo.save(places);

        return ResponseDto.builder().code(201).message("Place Added Successfully").build();
    }

    public ResponseDto updatePlace(PlaceDto placeDto) {

        Places places = placeRepo.findById(placeDto.getId()).orElse(null);

        if (places != null){

            places.setName(placeDto.getName());
            places.setDescription(placeDto.getDescription());
            places.setImgUrl(placeDto.getImgUrl());

            placeRepo.save(places);

            return ResponseDto.builder().code(200).message("Place Updated Successfully").build();
        }
        return ResponseDto.builder().code(400).message("Place already exists with name :" + placeDto.getName()).build();


    }
}
