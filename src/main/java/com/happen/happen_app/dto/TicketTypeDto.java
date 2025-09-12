package com.happen.happen_app.dto;

import com.happen.happen_app.entity.Event;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeDto {
    private Long id;
    private Event event;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer quantityAvailable;
    private Integer quantitySold;
    private LocalDateTime saleStartDate;
    private LocalDateTime saleEndDate;
    private Boolean isActive;
}
