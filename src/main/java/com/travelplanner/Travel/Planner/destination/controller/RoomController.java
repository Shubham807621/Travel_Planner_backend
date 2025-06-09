package com.travelplanner.Travel.Planner.destination.controller;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.RoomDTO;
import com.travelplanner.Travel.Planner.destination.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/room/{name}")
    public ResponseEntity<List<RoomDTO>> getRoomList(@PathVariable String name){

        List<RoomDTO> roomDTOS = roomService.getRoomList(name);

        return new ResponseEntity<>(roomDTOS, HttpStatus.OK);
    }

    @PostMapping("/add-room/{id}")
    public ResponseEntity<ResponseDto> addRoom(@PathVariable UUID id, @RequestBody RoomDTO roomDTO){

        ResponseDto responseDto = roomService.addRoom(id,roomDTO);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update-room")
    public ResponseEntity<ResponseDto> updateRoom(@RequestBody RoomDTO roomDTO){

        ResponseDto responseDto = roomService.updateRoom(roomDTO);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



}
