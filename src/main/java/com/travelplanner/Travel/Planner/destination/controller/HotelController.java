package com.travelplanner.Travel.Planner.destination.controller;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.*;
import com.travelplanner.Travel.Planner.destination.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel/list/{name}")
    public ResponseEntity<List<HotelListDto>> getAllHotels(@PathVariable String name){

        List<HotelListDto> hotelListDto = hotelService.getAllHotels(name);

        return new ResponseEntity<>(hotelListDto, HttpStatus.OK);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable UUID id){

        HotelDTO hotelDTO = hotelService.getHotelById(id);

        return new ResponseEntity<>(hotelDTO, HttpStatus.OK);
    }

    @PostMapping("/hotel/search")
    public ResponseEntity<List<SearchResponseDto>> searchHotels(@RequestBody SearchRequestDto searchRequestDto){

        List<SearchResponseDto> searchResponseDtos = hotelService.searchHotels(searchRequestDto);

        return new ResponseEntity<>(searchResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/add-hotel/{name}")
    public ResponseEntity<ResponseDto> addHotel(@RequestBody AddHotelDto addHotelDto, @PathVariable String name){

        ResponseDto responseDto = hotelService.addHotel(addHotelDto, name);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update-hotel")
    public ResponseEntity<ResponseDto> updateHotel(@RequestBody AddHotelDto addHotelDto){

        ResponseDto responseDto = hotelService.updateHotel(addHotelDto);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
