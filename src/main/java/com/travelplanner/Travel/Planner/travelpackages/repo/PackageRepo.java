package com.travelplanner.Travel.Planner.travelpackages.repo;

import com.travelplanner.Travel.Planner.travelpackages.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PackageRepo extends JpaRepository<TravelPackage, UUID> {


}
