package com.travelplanner.Travel.Planner.travelpackages.service;


import com.travelplanner.Travel.Planner.travelpackages.entity.TravelPackage;
import com.travelplanner.Travel.Planner.travelpackages.repo.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PackageService {

    @Autowired
    private PackageRepo packageRepo;


    public TravelPackage getPackageById(UUID id) {
        return packageRepo.findById(id).orElse(null);
    }
}
