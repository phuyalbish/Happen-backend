package com.happen.happen_app.dto;

import com.happen.happen_app.entity.EventStatus;
import com.happen.happen_app.entity.EventType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;
    private String title;
    private String description;
    private EventStatus status;
    private EventType type;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private LocalDateTime registrationStartDate;
    private LocalDateTime registrationEndDate;
    private Integer maxParticipants;
    private Integer currentParticipants;
    private Boolean isHidden;
}
