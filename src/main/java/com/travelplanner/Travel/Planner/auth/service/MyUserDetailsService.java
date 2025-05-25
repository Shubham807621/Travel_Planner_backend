package com.travelplanner.Travel.Planner.auth.service;

import com.travelplanner.Travel.Planner.auth.entity.Users;
import com.travelplanner.Travel.Planner.auth.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("User not Found"+ username);

        }
        return user;
    }
}
