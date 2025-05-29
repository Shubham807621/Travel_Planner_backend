package com.travelplanner.Travel.Planner.destination.mapper;

import com.travelplanner.Travel.Planner.destination.dto.*;
import com.travelplanner.Travel.Planner.destination.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtoMapper {

    public StateDTO toStateDto(States states) {

        return StateDTO.builder()
                .id(states.getId())
                .name(states.getName())
                .description(states.getDescription())
                .imgUrl(states.getImgUrl())
                .build();
    }

    public CityDTO toCityDto(City city) {

        return CityDTO.builder()
                .id(city.getId())
                .name(city.getName())
                .description(city.getDescription())
                .imgUrl(city.getImgUrl())
                .build();
    }


    public HotelDTO toHotelDto(Hotel hotel) {
        List<RoomDTO> roomDTOs = hotel.getRooms().stream()
                .map(this::toRoomDto)
                .toList();

        List<ReviewDTO> reviewDTOs = hotel.getReviews().stream()
                .map(this::toReviewDto)
                .toList();

        return new HotelDTO(hotel.getId(), hotel.getName(), hotel.getDescription(), hotel.getAddress(), hotel.getRating(),hotel.getImgUrl(), roomDTOs, reviewDTOs);
    }

    private ReviewDTO toReviewDto(Review review) {


        UsersDto userDto = UsersDto.builder()
                .id(review.getUser().getId())
                .firstName(review.getUser().getFirstName())
                .lastName(review.getUser().getLastName())
                .email(review.getUser().getEmail())
                .build();

        return ReviewDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(review.getCreatedAt())
                .user(userDto)
                .build();
    }

    public RoomDTO toRoomDto(Room room) {
        
        return RoomDTO.builder()
                .id(room.getId())
                .roomType(room.getRoomType())
                .pricePerNight(room.getPricePerNight())
                .capacity(room.getCapacity())               
                .build();
    }


    public HotelListDto toHotelListDto(Hotel hotel) {

        return HotelListDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .rating(hotel.getRating())
                .imgUrl(hotel.getImgUrl())
                .build();
    }
}

