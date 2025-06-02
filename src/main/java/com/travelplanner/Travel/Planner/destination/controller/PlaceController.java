package com.travelplanner.Travel.Planner.destination.controller;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.PlaceDto;
import com.travelplanner.Travel.Planner.destination.entity.Places;
import com.travelplanner.Travel.Planner.destination.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/get-places")
    public ResponseEntity<List<Places>> getAllPlaces(){

        List<Places> places = placeService.getAllPlaces();

        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @GetMapping("/get-places/{name}")
    public  ResponseEntity<List<PlaceDto>> getPlaceByCityName(@PathVariable String name){

        List<PlaceDto> placeDto = placeService.getPlaceByCityName(name);

        return new ResponseEntity<>(placeDto, HttpStatus.OK);


    }

    @PostMapping("/add-places/{name}")
    public ResponseEntity<ResponseDto> addPlace(@RequestBody PlaceDto placeDto, @PathVariable String name){

        ResponseDto responseDto = placeService.addPlace(placeDto, name);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }


}
