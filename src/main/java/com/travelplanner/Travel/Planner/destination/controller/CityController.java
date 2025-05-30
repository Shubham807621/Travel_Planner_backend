package com.travelplanner.Travel.Planner.destination.controller;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.CityDTO;
import com.travelplanner.Travel.Planner.destination.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities/{name}")
    public ResponseEntity<List<CityDTO>> getCitiesByStateName(@PathVariable String name){

        List<CityDTO> cityDTOS = cityService.getCitiesByStateName(name);

        return new ResponseEntity<>(cityDTOS, HttpStatus.OK);
    }

    @PostMapping("/add-city/{name}")
    public ResponseEntity<ResponseDto> addCity(@PathVariable String name, @RequestBody CityDTO cityDTO){

        ResponseDto responseDto = cityService.addCity(name , cityDTO);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update-city")
    public ResponseEntity<ResponseDto> updateCity(@RequestBody CityDTO cityDTO){

        ResponseDto responseDto = cityService.updateCity(cityDTO);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
