package com.happen.happen_app.mapper;

import com.happen.happen_app.entity.Venue;
import com.happen.happen_app.dto.VenueDto;

public class VenueMapper {
    public static Venue mapToVenue(VenueDto dto) {
        if (dto == null) {
            return null;
        }
        Venue entity = new Venue();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setCapacity(dto.getCapacity());
        entity.setHourlyRate(dto.getHourlyRate());
        entity.setContactPerson(dto.getContactPerson());
        entity.setAmenities(dto.getAmenities());
        entity.setImages(dto.getImages());
        entity.setIsActive(dto.getIsActive());
        entity.setEvents(dto.getEvents());
        return entity;
    }

    public static VenueDto mapToVenueDto(Venue entity) {
        if (entity == null) {
            return null;
        }
        VenueDto dto = new VenueDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setCapacity(entity.getCapacity());
        dto.setHourlyRate(entity.getHourlyRate());
        dto.setContactPerson(entity.getContactPerson());
        dto.setAmenities(entity.getAmenities());
        dto.setImages(entity.getImages());
        dto.setIsActive(entity.getIsActive());
        dto.setEvents(entity.getEvents());
        return dto;
    }
}