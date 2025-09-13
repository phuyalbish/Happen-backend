package com.happen.happen_app.service.impl;
import org.springframework.stereotype.Service;
import com.happen.happen_app.entity.Venue;
import com.happen.happen_app.dto.VenueDto;
import com.happen.happen_app.mapper.VenueMapper;
import com.happen.happen_app.repository.VenueRepository;
import com.happen.happen_app.service.VenueService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueServiceImpl implements VenueService {

    private VenueRepository venueRepository;
    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public VenueDto createVenue(VenueDto venueDto) {
        Venue venue = VenueMapper.mapToVenue(venueDto);
        Venue savedVenue = venueRepository.save(venue);
        return VenueMapper.mapToVenueDto(savedVenue);
    }

    @Override
    public VenueDto getVenueById(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue does not exist"));
        return VenueMapper.mapToVenueDto(venue);
    }

    @Override
    public List<VenueDto> getAllVenues() {
        return venueRepository.findAll()
                .stream()
                .map(VenueMapper::mapToVenueDto)
                .collect(Collectors.toList());
    }


    @Override
    public VenueDto updateVenue(Long id, VenueDto venueDto) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue does not exist"));

        venue.setName(venueDto.getName());
        venue.setDescription(venueDto.getDescription());
        venue.setAddress(venueDto.getAddress());
        venue.setCity(venueDto.getCity());
        venue.setState(venueDto.getState());
        venue.setLatitude(venueDto.getLatitude());
        venue.setLongitude(venueDto.getLongitude());
        venue.setCapacity(venueDto.getCapacity());
        venue.setHourlyRate(venueDto.getHourlyRate());
        venue.setContactPerson(venueDto.getContactPerson());
        venue.setAmenities(venueDto.getAmenities());
        venue.setImages(venueDto.getImages());
        venue.setIsActive(venueDto.getIsActive());
        venue.setEvents(venueDto.getEvents());
        Venue updatedVenue = venueRepository.save(venue);
        return VenueMapper.mapToVenueDto(updatedVenue);
    }

    @Override
    public void deleteVenue(Long id) {
        if (!venueRepository.existsById(id)) {
            throw new RuntimeException("Venue does not exist");
        }
        venueRepository.deleteById(id);
    }


}