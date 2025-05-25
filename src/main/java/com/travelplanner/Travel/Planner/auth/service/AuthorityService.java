package com.travelplanner.Travel.Planner.auth.service;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.auth.entity.Authority;
import com.travelplanner.Travel.Planner.auth.repo.AuthorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepo authorityRepo;

    public ResponseDto createAuthority(Authority authority) {
        Authority authority1= Authority.builder()
                                .roleCode(authority.getRoleCode())
                                .roleDescription(authority.getRoleDescription())
                                .build();

        authorityRepo.save(authority);

        return ResponseDto.builder()
                .code(200)
                .message("Role has been Created")
                .build();
    }
}
