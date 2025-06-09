package com.travelplanner.Travel.Planner.auth.repo;

import com.travelplanner.Travel.Planner.auth.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsersRepo extends JpaRepository<Users, UUID> {
    Users findByEmail(String username);

    @Query("SELECT u.userId FROM Users u WHERE u.userId LIKE CONCAT(:prefix, '%') ORDER BY u.userId DESC")
    List<String> findUserIdsByPrefix(@Param("prefix") String prefix);

    Users findByUserId(String userId);
}
