package com.travelplanner.Travel.Planner.auth.mapper;


import com.travelplanner.Travel.Planner.auth.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {

    @Autowired
    private UsersRepo userRepo;

    public String generateUserId(String rolePrefix) {
        // Ensure the rolePrefix is capitalized and valid
        if (!rolePrefix.equalsIgnoreCase("User") && !rolePrefix.equalsIgnoreCase("Admin")) {
            throw new IllegalArgumentException("Invalid role prefix: must be 'User' or 'Admin'");
        }

        rolePrefix = rolePrefix.substring(0, 1).toUpperCase() + rolePrefix.substring(1).toLowerCase();

        String lastId = userRepo.findLastUserIdByPrefix(rolePrefix); // e.g., "User11112" or "Admin11117"

        int nextIdNumber = 11111; // Default starting number
        if (lastId != null && lastId.startsWith(rolePrefix)) {
            String numberPart = lastId.substring(rolePrefix.length());
            try {
                nextIdNumber = Integer.parseInt(numberPart) + 1;
            } catch (NumberFormatException e) {
                // Ignore and use default
            }
        }

        return rolePrefix + nextIdNumber;
    }

}