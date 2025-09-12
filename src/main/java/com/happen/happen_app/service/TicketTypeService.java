package com.happen.happen_app.service;

import com.happen.happen_app.dto.TicketTypeDto;

import java.util.List;

public interface TicketTypeService {
    TicketTypeDto createTicketType(TicketTypeDto ticketTypeDto);
    TicketTypeDto getTicketTypeById(Long id);
    List<TicketTypeDto> getAllTicketTypes();
    TicketTypeDto updateTicketType(Long id, TicketTypeDto ticketTypeDto);
    void deleteTicketType(Long id);
}
