package com.travelplanner.Travel.Planner.destination.service;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.CityDTO;
import com.travelplanner.Travel.Planner.destination.entity.City;
import com.travelplanner.Travel.Planner.destination.entity.States;
import com.travelplanner.Travel.Planner.destination.mapper.DtoMapper;
import com.travelplanner.Travel.Planner.destination.repo.CityRepo;
import com.travelplanner.Travel.Planner.destination.repo.StatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private StatesRepo statesRepo;

    @Autowired
    private DtoMapper dtoMapper;

    public List<CityDTO> getCitiesByStateName(String name) {

        States states = statesRepo.findByName(name);

        List<City> cities = states.getCities();

        return cities.stream().map(dtoMapper::toCityDto).collect(Collectors.toList());
    }

    public ResponseDto addCity(String name, CityDTO cityDTO) {

        City existingCity = cityRepo.findByName(cityDTO.getName());

        if (existingCity != null){
            return ResponseDto.builder().code(400).message("City already exists with name :" + existingCity.getName()).build();
        }

        States states = statesRepo.findByName(name);

        City city = City.builder()
                .name(cityDTO.getName())
                .description(cityDTO.getDescription())
                .imgUrl(cityDTO.getImgUrl())
                .states(states)
                .build();

        cityRepo.save(city);

        return ResponseDto.builder().code(201).message("City Added Successfully").build();

    }
}
