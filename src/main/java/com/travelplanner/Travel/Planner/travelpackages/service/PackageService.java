package com.travelplanner.Travel.Planner.travelpackages.service;


import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.entity.City;
import com.travelplanner.Travel.Planner.destination.repo.CityRepo;
import com.travelplanner.Travel.Planner.travelpackages.dto.TravelPackageDetailsDTO;
import com.travelplanner.Travel.Planner.travelpackages.dto.TravelPackageDto;
import com.travelplanner.Travel.Planner.travelpackages.dto.TravelPackageRequestDto;
import com.travelplanner.Travel.Planner.travelpackages.entity.TravelPackage;
import com.travelplanner.Travel.Planner.travelpackages.mapper.TravelPackageMapper;
import com.travelplanner.Travel.Planner.travelpackages.repo.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PackageService {

    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private TravelPackageMapper travelPackageMapper;


    public TravelPackageDetailsDTO getPackageById(UUID id) {
        TravelPackage travelPackage = packageRepo.findById(id).orElse(null);

        assert travelPackage != null;
        return travelPackageMapper.toDetailsDTO(travelPackage);
    }

    public List<TravelPackageDto> getAllPackage() {

        List<TravelPackage> travelPackages = packageRepo.findAll();

        return travelPackages.stream().map(travelPackageMapper::toDto).collect(Collectors.toList());
    }


    public ResponseDto addPackage(TravelPackageRequestDto travelPackageRequestDto) {

        City city = cityRepo.findByNameIgnoreCase(travelPackageRequestDto.getCityName());

        TravelPackage travelPackage = travelPackageMapper.toEntity(travelPackageRequestDto, city);

        packageRepo.save(travelPackage);

        return ResponseDto.builder().code(201).message("Package Added Successfully").build();
    }

    public List<TravelPackageDto> getAllPackageByCityName(String name) {
        City city = cityRepo.findByNameIgnoreCase(name);

        if (city == null) {
            return new ArrayList<>(); // or throw an exception if preferred
        }

        // Step 2: Get packages linked to the city
        List<TravelPackage> travelPackages = packageRepo.findByCity(city);

        return travelPackages.stream().map(travelPackageMapper::toDto).collect(Collectors.toList());
    }
}
