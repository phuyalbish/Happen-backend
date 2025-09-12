package com.happen.happen_app.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRegistrationDto {
    private Long id;
    private Long venueId;
    private Long eventId;
    //  private Long userId;
    private LocalDateTime registrationDate;
    private String ticketType;
    private String specialRequirements;
    private BigDecimal amountPaid;
    private String paymentStatus;
    private String status;
}