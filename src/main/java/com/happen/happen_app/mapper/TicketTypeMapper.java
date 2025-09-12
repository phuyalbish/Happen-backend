package com.happen.happen_app.mapper;

import com.happen.happen_app.dto.TicketTypeDto;
import com.happen.happen_app.entity.TicketType;

public class TicketTypeMapper {

    public static TicketTypeDto mapToTicketTypeDto(TicketType entity) {
        if (entity == null) return null;
        TicketTypeDto dto = new TicketTypeDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setQuantityAvailable(entity.getQuantityAvailable());
        dto.setQuantitySold(entity.getQuantitySold());
        dto.setSaleStartDate(entity.getSaleStartDate());
        dto.setSaleEndDate(entity.getSaleEndDate());
        dto.setIsActive(entity.getIsActive());
//      dto.setEventId(entity.getEvent() != null ? entity.getEvent().getId() : null);
        return dto;
    }

    public static TicketType mapToTicketType(TicketTypeDto dto) {
        if (dto == null) return null;
        TicketType entity = new TicketType();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setQuantitySold(dto.getQuantitySold());
        entity.setSaleStartDate(dto.getSaleStartDate());
        entity.setSaleEndDate(dto.getSaleEndDate());
        entity.setIsActive(dto.getIsActive());
        return entity;
    }
}