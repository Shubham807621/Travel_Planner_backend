package com.travelplanner.Travel.Planner.destination.service;

import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.StateDTO;
import com.travelplanner.Travel.Planner.destination.entity.Resources;
import com.travelplanner.Travel.Planner.destination.entity.States;
import com.travelplanner.Travel.Planner.destination.mapper.DtoMapper;
import com.travelplanner.Travel.Planner.destination.repo.StatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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
    public StateDTO getStateByName(String name) {
        States states= statesRepo.findByName(name);
        assert states != null;
        return dtoMapper.toStateDto(states);
    }
    public ResponseDto addStates(StateDTO stateDTO) {

        States states = statesRepo.findByName(stateDTO.getName());

        if (states != null){
            return ResponseDto.builder().code(400).message("State already exists with name :" + states.getName()).build();
        }

        States states1 = States.builder()
                        .name(stateDTO.getName())
                        .description(stateDTO.getDescription())
                        .imgUrl(stateDTO.getImgUrl())
                        .build();
        statesRepo.save(states1);

        return ResponseDto.builder().code(201).message("State Added Successfully").build();

    }

    public ResponseDto updateStates(StateDTO stateDTO) {

        States states = statesRepo.findByName(stateDTO.getName());
        if (states != null){
                 states.setName(stateDTO.getName());
                 states.setDescription(stateDTO.getDescription());
                 states.setImgUrl(stateDTO.getImgUrl());
            List<Resources> newResources = stateDTO.getResources();
            if (newResources != null) {
                // Clear the old list
                states.getResources().clear();

                // Assign new resources
                for (Resources resource : newResources) {
                    resource.setStates(states); // maintain bidirectional relationship
                    states.getResources().add(resource);
                }
            }

            statesRepo.save(states);

            return ResponseDto.builder().code(201).message("State Updated Successfully").build();
        }

        return ResponseDto.builder().code(400).message("State not exists with name :" + stateDTO.getName()).build();

    }


}
