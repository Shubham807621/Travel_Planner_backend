package com.travelplanner.Travel.Planner.travelpackages.controller;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.travelpackages.dto.TravelPackageDetailsDTO;
import com.travelplanner.Travel.Planner.travelpackages.dto.TravelPackageDto;
import com.travelplanner.Travel.Planner.travelpackages.dto.TravelPackageRequestDto;
import com.travelplanner.Travel.Planner.travelpackages.entity.TravelPackage;
import com.travelplanner.Travel.Planner.travelpackages.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/packages/{id}")
    public ResponseEntity<TravelPackageDetailsDTO> getPackageById(@PathVariable UUID id){

        TravelPackageDetailsDTO travelPackage = packageService.getPackageById(id);

        return new ResponseEntity<>(travelPackage, HttpStatus.OK);
    }

    @GetMapping("/packages")
    public ResponseEntity<List<TravelPackageDto>> getAllPackage(){

        List<TravelPackageDto> travelPackages = packageService.getAllPackage();

        return new ResponseEntity<>(travelPackages, HttpStatus.OK);
    }

    @PostMapping("/add-package")
    public ResponseEntity<ResponseDto> addPackage(@RequestBody TravelPackageRequestDto travelPackageRequestDto){

        ResponseDto responseDto = packageService.addPackage(travelPackageRequestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/packages/get-packages-byCity/{name}")
    public ResponseEntity<List<TravelPackageDto>> getAllPackageByCityName(@PathVariable String name){

        List<TravelPackageDto> travelPackages = packageService.getAllPackageByCityName(name);

        return new ResponseEntity<>(travelPackages, HttpStatus.OK);
    }
}
