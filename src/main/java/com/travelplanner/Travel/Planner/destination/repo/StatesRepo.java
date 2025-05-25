package com.travelplanner.Travel.Planner.destination.repo;

import com.travelplanner.Travel.Planner.destination.entity.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StatesRepo extends JpaRepository<States, UUID> {
    States findByName(String name);
}
