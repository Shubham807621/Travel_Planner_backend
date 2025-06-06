package com.travelplanner.Travel.Planner.auth.repo;

import com.travelplanner.Travel.Planner.auth.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorityRepo extends JpaRepository<Authority, UUID> {
    Authority findByRoleCode(String upperCase);
}
