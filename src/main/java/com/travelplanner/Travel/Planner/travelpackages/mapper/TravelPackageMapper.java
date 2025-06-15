package com.travelplanner.Travel.Planner.travelpackages.mapper;

import com.travelplanner.Travel.Planner.destination.entity.City;
import com.travelplanner.Travel.Planner.destination.entity.Hotel;
import com.travelplanner.Travel.Planner.destination.entity.Room;
import com.travelplanner.Travel.Planner.destination.dto.RoomDTO;
import com.travelplanner.Travel.Planner.travelpackages.dto.*;
import com.travelplanner.Travel.Planner.travelpackages.entity.Activity;
import com.travelplanner.Travel.Planner.travelpackages.entity.TravelPackage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TravelPackageMapper {

    public TravelPackage toEntity(TravelPackageRequestDto dto, City city) {
        TravelPackage travelPackage = new TravelPackage();
        travelPackage.setPackageName(dto.getPackageName());
        travelPackage.setGroupPackage(dto.isGroupPackage());
        travelPackage.setPrice(dto.getPrice());
        travelPackage.setDurationInDays(dto.getDurationInDays());
        travelPackage.setCity(city);

        // Map hotels with rooms
        if (dto.getHotels() != null) {
            List<Hotel> hotels = dto.getHotels().stream().map(h -> {
                Hotel hotel = new Hotel();
                hotel.setName(h.getName());
                hotel.setAddress(h.getAddress());
                hotel.setRating(h.getRating());
                hotel.setTravelPackage(travelPackage);

                // Map rooms inside each hotel
                if (h.getRooms() != null) {
                    List<Room> rooms = h.getRooms().stream().map(r -> {
                        Room room = new Room();
                        // Optional: Only set ID if it's not null (for update cases)
                        if (r.getId() != null) {
                            room.setId(r.getId());
                        }
                        room.setRoomType(r.getRoomType());
                        room.setCapacity(r.getCapacity());
                        room.setPricePerNight(r.getPricePerNight());
                        room.setHotel(hotel); // associate room with hotel
                        return room;
                    }).collect(Collectors.toList());
                    hotel.setRooms(rooms);
                }

                return hotel;
            }).collect(Collectors.toList());

            travelPackage.setHotels(hotels);
        }

        // Map activities
        if (dto.getActivities() != null) {
            List<Activity> activities = dto.getActivities().stream().map(a -> {
                Activity activity = new Activity();
                activity.setName(a.getName());
                activity.setDescription(a.getDescription());
                activity.setPrice(a.getPrice());
                activity.setOutdoor(a.isOutdoor());
                activity.setTravelPackage(travelPackage);
                return activity;
            }).collect(Collectors.toList());

            travelPackage.setActivities(activities);
        }

        return travelPackage;
    }

    public TravelPackageDto toDto(TravelPackage travelPackage) {

        return TravelPackageDto.builder()
                .id(travelPackage.getId())
                .packageName(travelPackage.getPackageName())
                .isGroupPackage(travelPackage.isGroupPackage())
                .price(travelPackage.getPrice())
                .durationInDays(travelPackage.getDurationInDays())
                .cityName(travelPackage.getCity().getName())
                .build();
    }

    public TravelPackageDetailsDTO toDetailsDTO(TravelPackage travelPackage) {
        return TravelPackageDetailsDTO.builder()
                .id(travelPackage.getId())
                .packageName(travelPackage.getPackageName())
                .groupPackage(travelPackage.isGroupPackage())
                .price(travelPackage.getPrice())
                .durationInDays(travelPackage.getDurationInDays())
                .cityName(travelPackage.getCity() != null ? travelPackage.getCity().getName() : null)
                .hotels(mapHotels(travelPackage.getHotels()))
                .activities(mapActivities(travelPackage.getActivities()))
                .build();
    }


    private  List<PackageHotelDto> mapHotels(List<Hotel> hotels) {
        return hotels.stream().map(hotel -> PackageHotelDto.builder()
                .name(hotel.getName())
                .address(hotel.getAddress())
                .rating(hotel.getRating())
                .rooms(mapRooms(hotel.getRooms()))
                .build()
        ).collect(Collectors.toList());
    }

    private  List<RoomDTO> mapRooms(List<Room> rooms) {
        if (rooms == null) return List.of();
        return rooms.stream().map(room -> RoomDTO.builder()
                .id(room.getId())
                .roomType(room.getRoomType())
                .capacity(room.getCapacity())
                .roomSize(room.getRoomSize())
                .view(room.getView())
                .bedType(room.getBedType())
                .pricePerNight(room.getPricePerNight())
                .build()
        ).collect(Collectors.toList());
    }


    private List<ActivityDto> mapActivities(List<Activity> activities) {
        if (activities == null) return List.of();
        return activities.stream().map(activity -> ActivityDto.builder()
                .id(activity.getId())
                .name(activity.getName())
                .description(activity.getDescription())
                .price(activity.getPrice())
                .isOutdoor(activity.isOutdoor())
                .build()
        ).collect(Collectors.toList());
    }
}
