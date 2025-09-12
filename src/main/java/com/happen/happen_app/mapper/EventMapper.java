package com.happen.happen_app.mapper;

import com.happen.happen_app.dto.EventDto;
import com.happen.happen_app.entity.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto dto) {
        if (dto == null) return null;
        Event entity = new Event();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setType(dto.getType());
        entity.setStartDateTime(dto.getStartDateTime());
        entity.setEndDateTime(dto.getEndDateTime());
        entity.setRegistrationStartDate(dto.getRegistrationStartDate());
        entity.setRegistrationEndDate(dto.getRegistrationEndDate());
        entity.setMaxParticipants(dto.getMaxParticipants());
        entity.setCurrentParticipants(dto.getCurrentParticipants());
        entity.setIsHidden(dto.getIsHidden());
        return entity;
    }

    public static EventDto mapToEventDto(Event entity) {
        if (entity == null) return null;

        EventDto dto = new EventDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setType(entity.getType());
        dto.setStartDateTime(entity.getStartDateTime());
        dto.setEndDateTime(entity.getEndDateTime());
        dto.setRegistrationStartDate(entity.getRegistrationStartDate());
        dto.setRegistrationEndDate(entity.getRegistrationEndDate());
        dto.setMaxParticipants(entity.getMaxParticipants());
        dto.setCurrentParticipants(entity.getCurrentParticipants());
        dto.setIsHidden(entity.getIsHidden());
        return dto;
    }
}