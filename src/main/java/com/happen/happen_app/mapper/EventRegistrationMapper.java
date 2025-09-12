package com.happen.happen_app.mapper;

import com.happen.happen_app.dto.EventRegistrationDto;
import com.happen.happen_app.entity.*;

public class EventRegistrationMapper {

    public static EventRegistration mapToEventRegistration(EventRegistrationDto dto) {
        if (dto == null) return null;

        EventRegistration entity = new EventRegistration();
        entity.setId(dto.getId());

        if (dto.getVenueId() != null) {
            Venue venue = new Venue();
            venue.setId(dto.getVenueId());
            entity.setVenue(venue);
        }
        if (dto.getEventId() != null) {
            Event event = new Event();
            event.setId(dto.getEventId());
            entity.setEvent(event);
        }

        entity.setRegistrationDate(dto.getRegistrationDate());
        entity.setTicketType(dto.getTicketType());
        entity.setSpecialRequirements(dto.getSpecialRequirements());
        entity.setAmountPaid(dto.getAmountPaid());
        if (dto.getStatus() != null) {
            entity.setStatus(EventRegistrationStatus.valueOf(dto.getStatus()));
        }
        if (dto.getPaymentStatus() != null) {
            entity.setPaymentStatus(PaymentStatus.valueOf(dto.getPaymentStatus()));
        }
        return entity;
    }

    public static EventRegistrationDto mapToEventRegistrationDto(EventRegistration entity) {
        if (entity == null) return null;

        EventRegistrationDto dto = new EventRegistrationDto();
        dto.setId(entity.getId());
        dto.setVenueId(entity.getVenue() != null ? entity.getVenue().getId() : null);
        dto.setEventId(entity.getEvent() != null ? entity.getEvent().getId() : null);
        dto.setRegistrationDate(entity.getRegistrationDate());
        dto.setTicketType(entity.getTicketType());
        dto.setSpecialRequirements(entity.getSpecialRequirements());
        dto.setAmountPaid(entity.getAmountPaid());
        dto.setStatus(entity.getStatus() != null ? entity.getStatus().name() : null);
        dto.setPaymentStatus(entity.getPaymentStatus() != null ? entity.getPaymentStatus().name() : null);

        return dto;
    }
}