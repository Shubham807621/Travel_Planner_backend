package com.travelplanner.Travel.Planner.travelpackages.service;


import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.entity.City;
import com.travelplanner.Travel.Planner.destination.repo.CityRepo;
import com.travelplanner.Travel.Planner.travelpackages.dto.TravelPackageDto;
import com.travelplanner.Travel.Planner.travelpackages.dto.TravelPackageRequestDto;
import com.travelplanner.Travel.Planner.travelpackages.entity.TravelPackage;
import com.travelplanner.Travel.Planner.travelpackages.mapper.TravelPackageMapper;
import com.travelplanner.Travel.Planner.travelpackages.repo.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public TravelPackage getPackageById(UUID id) {
        return packageRepo.findById(id).orElse(null);
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
}
