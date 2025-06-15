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
                .resources(states.getResources())
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
                .view(room.getView())
                .roomSize(room.getRoomSize())
                .bedType(room.getBedType())
                .pricePerNight(room.getPricePerNight())
                .imgUrl(room.getImgUrl())
                .capacity(room.getCapacity())
                .available(room.getAvailable())
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

    public PlaceDto toPlaceDto(Places places) {

        return PlaceDto.builder()
                .id(places.getId())
                .name(places.getName())
                .description(places.getDescription())
                .imgUrl(places.getImgUrl())
                .build();
    }

    public SearchResponseDto toSearchDto(Hotel hotel) {

        return SearchResponseDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .imgUrl(hotel.getImgUrl())
                .rating(hotel.getRating())
                .cityName(hotel.getCity() !=null ? hotel.getCity().getName(): null)
                .build();

    }
}

