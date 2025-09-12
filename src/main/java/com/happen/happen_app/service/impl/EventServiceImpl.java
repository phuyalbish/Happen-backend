package com.happen.happen_app.service.impl;
import org.springframework.stereotype.Service;
import com.happen.happen_app.entity.Event;
import com.happen.happen_app.dto.EventDto;
import com.happen.happen_app.mapper.EventMapper;
import com.happen.happen_app.repository.EventRepository;
import com.happen.happen_app.service.EventService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = EventMapper.mapToEvent(eventDto);
        Event savedEvent = eventRepository.save(event);
        return EventMapper.mapToEventDto(savedEvent);
    }

    @Override
    public EventDto getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event does not exist"));
        return EventMapper.mapToEventDto(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getUnhiddenEvents() {
        return eventRepository.findAll()
                .stream()
                .filter(event -> !event.getIsHidden())
                .map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }
    @Override
    public EventDto updateEvent(Long id, EventDto eventDto) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event does not exist"));
        event.setId(eventDto.getId());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setStatus(eventDto.getStatus());
        event.setType(eventDto.getType());
        event.setStartDateTime(eventDto.getStartDateTime());
        event.setEndDateTime(eventDto.getEndDateTime());
        event.setRegistrationStartDate(eventDto.getRegistrationStartDate());
        event.setRegistrationEndDate(eventDto.getRegistrationEndDate());
        event.setMaxParticipants(eventDto.getMaxParticipants());
        event.setCurrentParticipants(eventDto.getCurrentParticipants());
        event.setIsHidden(eventDto.getIsHidden());
        Event updatedEvent = eventRepository.save(event);
        return EventMapper.mapToEventDto(updatedEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event does not exist");
        }
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventDto> getUpcomingEvents() {
        return eventRepository.findAll()
                .stream()
                .filter(event -> event.getStartDateTime().isAfter(java.time.LocalDateTime.now()))
                .map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getHomePageEvents() {
        return eventRepository.findAll()
                .stream()
                .limit(5) // just an example, get top 5
                .map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }
}