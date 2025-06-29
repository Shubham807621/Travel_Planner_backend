package com.travelplanner.Travel.Planner.auth.mapper;


import com.travelplanner.Travel.Planner.auth.dto.UserDto;
import com.travelplanner.Travel.Planner.auth.entity.Users;
import com.travelplanner.Travel.Planner.auth.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserHelper {

    @Autowired
    private UsersRepo userRepo;

    public String generateUserId(String rolePrefix) {
        if (!rolePrefix.equalsIgnoreCase("User") && !rolePrefix.equalsIgnoreCase("Admin")) {
            throw new IllegalArgumentException("Invalid role prefix: must be 'User' or 'Admin'");
        }

        rolePrefix = rolePrefix.substring(0, 1).toUpperCase() + rolePrefix.substring(1).toLowerCase();

        List<String> userIds = userRepo.findUserIdsByPrefix(rolePrefix);
        String lastId = userIds.isEmpty() ? null : userIds.get(0); // Get ONLY the first one

        int nextIdNumber = 11111;
        if (lastId != null && lastId.startsWith(rolePrefix)) {
            String numberPart = lastId.substring(rolePrefix.length());
            try {
                nextIdNumber = Integer.parseInt(numberPart) + 1;
            } catch (NumberFormatException e) {
                // Ignore
            }
        }

        return rolePrefix + nextIdNumber;
    }


    public UserDto userDto(Users users) {

        String name = users.getFirstName() + " " + users.getLastName();
        String role = users.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("User");

        return UserDto.builder()
                .id(users.getId())
                .name(name)
                .email(users.getEmail())
                .role(role)
                .phoneNumber(users.getPhoneNumber())
                .build();
    }
}