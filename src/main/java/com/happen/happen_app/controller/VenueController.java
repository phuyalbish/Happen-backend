package com.happen.happen_app.controller;

import com.happen.happen_app.dto.VenueDto;
import com.happen.happen_app.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    private VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping
    public ResponseEntity<VenueDto> addVenue(@RequestBody VenueDto venueDto) {
        return new ResponseEntity<>(venueService.createVenue(venueDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueDto> getVenueById(@PathVariable Long id) {
        VenueDto venueDto = venueService.getVenueById(id);
        return ResponseEntity.ok(venueDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VenueDto>> getAllVenues() {
        return ResponseEntity.ok(venueService.getAllVenues());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenueDto> updateVenue(@PathVariable Long id, @RequestBody VenueDto venueDto) {
        return ResponseEntity.ok(venueService.updateVenue(id, venueDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
        return ResponseEntity.ok("Venue deleted successfully");
    }

}