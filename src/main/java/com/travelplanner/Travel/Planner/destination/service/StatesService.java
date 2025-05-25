package com.travelplanner.Travel.Planner.destination.service;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.StateDTO;
import com.travelplanner.Travel.Planner.destination.entity.States;
import com.travelplanner.Travel.Planner.destination.mapper.DtoMapper;
import com.travelplanner.Travel.Planner.destination.repo.StatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatesService {

        @Autowired
        private StatesRepo statesRepo;

        @Autowired
        private DtoMapper dtoMapper;

    public List<StateDTO> getAllStates() {

        List<States> states = statesRepo.findAll();

        return states.stream()
                .map(dtoMapper::toStateDto)
                .collect(Collectors.toList());
    }

    public ResponseDto addStates(StateDTO stateDTO) {

        States states = statesRepo.findByName(stateDTO.getName());

        if (states != null){
            return ResponseDto.builder().code(400).message("State already exists with name :" + states.getName()).build();
        }

        States states1 = States.builder()
                        .name(stateDTO.getName())
                        .description(stateDTO.getDescription())
                        .build();
        statesRepo.save(states1);

        return ResponseDto.builder().code(201).message("State Added Successfully").build();

    }
}
