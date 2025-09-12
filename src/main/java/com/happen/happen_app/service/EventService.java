package com.happen.happen_app.service;
import java.util.List;
import com.happen.happen_app.dto.EventDto;

public interface EventService {
    EventDto createEvent(EventDto eventDto);
    EventDto getEventById(Long id);
    List<EventDto> getAllEvents();
    List<EventDto> getUnhiddenEvents();
    EventDto updateEvent(Long id, EventDto eventDto);
    void deleteEvent(Long id);
    List<EventDto> getUpcomingEvents();
    List<EventDto> getHomePageEvents();
}