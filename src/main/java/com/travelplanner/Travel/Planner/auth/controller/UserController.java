package com.travelplanner.Travel.Planner.auth.controller;

import com.travelplanner.Travel.Planner.auth.config.JWTTokenHelper;
import com.travelplanner.Travel.Planner.auth.dto.*;
import com.travelplanner.Travel.Planner.auth.entity.Authority;
import com.travelplanner.Travel.Planner.auth.entity.Users;
import com.travelplanner.Travel.Planner.auth.service.AuthorityService;
import com.travelplanner.Travel.Planner.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenHelper jwtTokenHelper;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody RegistrationRequest registrationRequest){

        ResponseDto responseBodyDto = userService.register(registrationRequest);

        return new ResponseEntity<>(responseBodyDto, HttpStatus.CREATED);
    }

    @PostMapping("/add-role")
    public ResponseEntity<ResponseDto> addRole(@RequestBody Authority authority){

        ResponseDto responseBodyDto = authorityService.createAuthority(authority);

        return new ResponseEntity<>(responseBodyDto, HttpStatus.CREATED);

    }
    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@RequestBody LoginRequest loginRequest){

        try{
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    loginRequest.getUserName(), loginRequest.getPassword());

            Authentication authenticationResponse=this.authenticationManager.authenticate(authentication);

            if (authenticationResponse.isAuthenticated()){
                Users users= (Users) authenticationResponse.getPrincipal();

                if (!users.isEnabled()){
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }

                String Token= jwtTokenHelper.generateToken(users.getEmail());

                String role = users.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .findFirst()
                        .orElse("User");


                UserToken userToken = UserToken.builder()
                        .token(Token)
                        .role(role)
                        .userId(users.getUserId())
                        .build();

                return new ResponseEntity<>(userToken,HttpStatus.OK);
            }

        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


    @GetMapping("/user-list")
    public ResponseEntity<List<UserDto>> getUserList(){

        List<UserDto> userDtoList = userService.getUserList();

        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @GetMapping("/user-details/{userId}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable String userId) {

        UserDto userDto = userService.getUserDetails(userId);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
