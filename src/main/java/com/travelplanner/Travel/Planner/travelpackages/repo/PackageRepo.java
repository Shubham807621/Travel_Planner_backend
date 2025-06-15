package com.travelplanner.Travel.Planner.travelpackages.repo;

import com.travelplanner.Travel.Planner.destination.entity.City;
import com.travelplanner.Travel.Planner.travelpackages.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PackageRepo extends JpaRepository<TravelPackage, UUID> {


    List<TravelPackage> findByCity(City city);
}
