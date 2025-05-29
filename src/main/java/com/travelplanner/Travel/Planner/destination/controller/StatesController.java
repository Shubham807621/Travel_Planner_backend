package com.travelplanner.Travel.Planner.destination.controller;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.StateDTO;
import com.travelplanner.Travel.Planner.destination.service.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StatesController {

    @Autowired
    private StatesService statesService;


    @GetMapping("/get_states")
    public ResponseEntity<List<StateDTO>> getAllStates(){

        List<StateDTO> stateDTOS = statesService.getAllStates();

        return new ResponseEntity<>(stateDTOS, HttpStatus.OK);
    }

    @PostMapping("/add-states")
    public ResponseEntity<ResponseDto> addStates(@RequestBody StateDTO stateDTO){

        ResponseDto responseDto = statesService.addStates(stateDTO);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update-state")
    public ResponseEntity<ResponseDto> updateStates(@RequestBody StateDTO stateDTO){

        ResponseDto responseDto = statesService.updateStates(stateDTO);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
