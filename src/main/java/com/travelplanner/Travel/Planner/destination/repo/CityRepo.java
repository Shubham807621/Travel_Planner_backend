package com.travelplanner.Travel.Planner.destination.repo;

import com.travelplanner.Travel.Planner.destination.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepo extends JpaRepository<City, UUID> {

    City findByName(String name);

    City findByNameIgnoreCase(String cityName);
}
