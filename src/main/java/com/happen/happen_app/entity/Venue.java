package com.happen.happen_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venue")
@Entity
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "venue_name")
    private String name;

    @Column(name = "venue_description")
    private String description;

    @Column(name = "venue_address")
    private String address;

    @Column(name = "venue_city")
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "venue_state")
    private VenueState state = VenueState.BAGMATI;

    @Column(name = "venue_latitude")
    private String latitude;

    @Column(name = "venue_longitude")
    private String longitude;

    @Column(name = "venue_capacity")
    private Integer capacity;

    @Column(name = "venue_hourlyRate")
    private BigDecimal hourlyRate;

    @Column(name = "venue_contactPerson")
    private String contactPerson;

    @ElementCollection
    @CollectionTable(name = "venue_amenities", joinColumns = @JoinColumn(name = "venue_id"))
    @Column(name = "amenity")
    private List<String> amenities = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "venue_images", joinColumns = @JoinColumn(name = "venue_id"))
    @Column(name = "image_url")
    private List<String> images = new ArrayList<>();

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive = true;

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    public String getFullAddress() {
        return String.format("%s, %s, %s %s, %s",
                address != null ? address : "",
                city != null ? city : "",
                state != null ? state.name() : "");
    }

    public boolean isAvailableForPeriod(LocalDateTime start, LocalDateTime end) {
        return events.stream()
                .noneMatch(event -> event.getStartDateTime().isBefore(end) && event.getEndDateTime().isAfter(start));
    }

    public BigDecimal calculateCost(int durationInHours) {
        if (hourlyRate == null) {
            return BigDecimal.ZERO;
        }
        return hourlyRate.multiply(BigDecimal.valueOf(durationInHours));
    }
}