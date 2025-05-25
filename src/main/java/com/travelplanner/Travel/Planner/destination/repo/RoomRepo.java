package com.travelplanner.Travel.Planner.destination.repo;

import com.travelplanner.Travel.Planner.destination.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepo extends JpaRepository<Room, UUID> {
    Room findByRoomType(String roomType);
}
