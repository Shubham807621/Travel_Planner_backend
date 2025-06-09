package com.travelplanner.Travel.Planner.destination.service;


import com.travelplanner.Travel.Planner.auth.dto.ResponseDto;
import com.travelplanner.Travel.Planner.destination.dto.RoomDTO;
import com.travelplanner.Travel.Planner.destination.entity.Hotel;
import com.travelplanner.Travel.Planner.destination.entity.Room;
import com.travelplanner.Travel.Planner.destination.mapper.DtoMapper;
import com.travelplanner.Travel.Planner.destination.repo.HotelRepo;
import com.travelplanner.Travel.Planner.destination.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private DtoMapper dtoMapper;

    public List<RoomDTO> getRoomList(String name) {

        Hotel hotel = hotelRepo.findByName(name);

        List<Room> rooms = hotel.getRooms();

        return rooms.stream().map(dtoMapper::toRoomDto).collect(Collectors.toList());
    }

    public ResponseDto addRoom(UUID id, RoomDTO roomDTO) {

        Room existingRoom = roomRepo.findByRoomType(roomDTO.getRoomType());

        if (existingRoom != null){
            return ResponseDto.builder().code(400).message("Room already exists with name :" + existingRoom.getRoomType()).build();
        }

        Hotel hotel = hotelRepo.findById(id).orElse(null);

        Room room = Room.builder()
                .hotel(hotel)
                .roomType(roomDTO.getRoomType())
                .capacity(roomDTO.getCapacity())
                .roomSize(roomDTO.getRoomSize())
                .view(roomDTO.getView())
                .bedType(roomDTO.getBedType())
                .imgUrl(roomDTO.getImgUrl())
                .pricePerNight(roomDTO.getPricePerNight())
                .build();

        roomRepo.save(room);

        return ResponseDto.builder().code(201).message("Room Added Successfully").build();
    }

    public ResponseDto updateRoom(RoomDTO roomDTO) {
        Room existingRoom = roomRepo.findById(roomDTO.getId()).orElse(null);

        if (existingRoom != null){
                existingRoom.setRoomType(roomDTO.getRoomType());
                existingRoom.setCapacity(roomDTO.getCapacity());
                existingRoom.setRoomSize(roomDTO.getRoomSize());
                existingRoom.setView(roomDTO.getView());
                existingRoom.setBedType(roomDTO.getBedType());
                existingRoom.setImgUrl(roomDTO.getImgUrl());
                existingRoom.setPricePerNight(roomDTO.getPricePerNight());
            roomRepo.save(existingRoom);
            return ResponseDto.builder().code(201).message("Room Updated Successfully").build();

        }
        return ResponseDto.builder().code(400).message("Room already exists with name :" + existingRoom.getRoomType()).build();

    }
}
