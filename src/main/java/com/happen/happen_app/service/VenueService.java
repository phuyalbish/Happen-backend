package com.happen.happen_app.service;
import java.util.List;
import com.happen.happen_app.dto.VenueDto;

public interface VenueService {
    VenueDto createVenue(VenueDto venueDto);
    VenueDto getVenueById(Long id);
    List<VenueDto> getAllVenues();
    VenueDto updateVenue(Long id, VenueDto venueDto);
    void deleteVenue(Long id);
}