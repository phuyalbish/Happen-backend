package com.happen.happen_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_title")
    private String title;
    @Column(name = "event_description")
    private String description;
    
    @Column(name = "event_start_date")
    private LocalDateTime startDateTime = LocalDateTime.now().plusDays(5);

    @Column(name = "event_end_date")
    private LocalDateTime endDateTime = null;

    @Column(name = "event_registration_start_date", nullable = false)
    private LocalDateTime registrationStartDate = LocalDateTime.now();

    @Column(name = "event_registration_end_date", nullable = false)
    private LocalDateTime registrationEndDate = LocalDateTime.now().plusDays(5);

    @Column(name = "event_max_participants", columnDefinition = "INT DEFAULT 0")
    private Integer maxParticipants = 0;

    @Column(name = "event_current_participants", columnDefinition = "INT DEFAULT 0")
    private Integer currentParticipants = 0;

    @Column(name = "is_hidden", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isHidden = false;

    @ElementCollection
    @CollectionTable(name = "event_images", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "image_url")
    private List<String> images = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "event_tags", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "tag")
    private List<String> tags = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "event_metadata", joinColumns = @JoinColumn(name = "event_id"))
    @MapKeyColumn(name = "meta_key")
    @Column(name = "meta_value")
    private Map<String, String> metadata = new HashMap<>();


    @Enumerated(EnumType.STRING)
    @Column(name = "event_status", nullable = false)
    private EventStatus status = EventStatus.DRAFT;


    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventType type = EventType.CONFERENCE;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketType> ticketTypes = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public boolean isRegistrationOpen() {
        LocalDateTime now = LocalDateTime.now();
        return !isHidden
                && status == EventStatus.PUBLISHED
                && now.isAfter(registrationStartDate)
                && now.isBefore(registrationEndDate)
                && hasAvailableSlots();
    }

    public boolean hasAvailableSlots() {
        return maxParticipants == 0 || currentParticipants < maxParticipants;
    }

    public Duration getDuration() {
        if (startDateTime != null && endDateTime != null) {
            return Duration.between(startDateTime, endDateTime);
        }
        return Duration.ZERO;
    }

    public boolean isUpcoming() {
        LocalDateTime now = LocalDateTime.now();
        return startDateTime != null && startDateTime.isAfter(now);
    }

//    public boolean canUserRegister(User user) {
//        // Simplified logic:
//        // 1. Registration must be open
//        // 2. User must not be null
//        // 3. (Optional) Could check if user already registered
//
//        if (user == null) return false;
//        return isRegistrationOpen();
//    }

}