package com.happen.happen_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event_registration")
@Entity
public class EventRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(name = "event_registration_date", nullable = false)
    private LocalDateTime registrationDate = LocalDateTime.now();

    @Column(name = "event_registration_ticket_type")
    private String ticketType;

    @Column(name = "event_registration_special_requirements")
    private String specialRequirements;

    @Column(name = "event_registration_amount_paid")
    private BigDecimal amountPaid;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_registration_status", nullable = false)
    private EventRegistrationStatus status = EventRegistrationStatus.REGISTERED;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_payment_status", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
