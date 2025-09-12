package com.happen.happen_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import java.time.Duration;
//import java.util.List;
//import java.util.Map;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket_types")
@Entity
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;


    @Column(name = "ticket_type_title")
    private String title;

    @Column(name = "ticket_type_description")
    private String description;

    @Column(name = "ticket_type_price")
    private BigDecimal price;

    @Column(name = "ticket_type_quantity_available")
    private Integer quantityAvailable;


    @Column(name = "ticket_type_quantity_sold")
    private Integer quantitySold;


    @Column(name = "ticket_type_sale_start_date", nullable = false)
    private LocalDateTime saleStartDate = LocalDateTime.now();

    @Column(name = "ticket_type_sale_end_date", nullable = false)
    private LocalDateTime saleEndDate = LocalDateTime.now();

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive = false;



    public boolean isSoldOut() {
        return quantitySold >= quantityAvailable;
    }

    public boolean isOnSale() {
        return saleStartDate != null
                && saleEndDate != null
                && LocalDateTime.now().isAfter(saleStartDate)
                && LocalDateTime.now().isBefore(saleEndDate);
    }
    public int getRemainingQuantity(){
        if(isSoldOut()){
            return 0;
        }
        return quantityAvailable - quantitySold;
    }

}