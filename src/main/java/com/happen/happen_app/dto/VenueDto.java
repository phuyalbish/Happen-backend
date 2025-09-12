package com.happen.happen_app.dto;

import com.happen.happen_app.entity.Event;
import com.happen.happen_app.entity.VenueState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String city;
    private VenueState state;
    private String latitude;
    private String longitude;
    private Integer capacity;
    private BigDecimal hourlyRate;
    private String contactPerson;
    private List<String> amenities;
    private List<String> images;
    private Boolean isActive;
    private List<Event> events;
}
