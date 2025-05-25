package com.travelplanner.Travel.Planner.travelpackages.controller;

import com.travelplanner.Travel.Planner.travelpackages.entity.TravelPackage;
import com.travelplanner.Travel.Planner.travelpackages.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/packages/{id}")
    public ResponseEntity<TravelPackage> getPackageById(@PathVariable UUID id){

        TravelPackage travelPackage = packageService.getPackageById(id);

        return new ResponseEntity<>(travelPackage, HttpStatus.OK);
    }
}
