package com.travelplanner.Travel.Planner.destination.repo;

import com.travelplanner.Travel.Planner.destination.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, UUID> {
    Hotel findByName(String name);
}
