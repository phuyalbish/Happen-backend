package com.happen.happen_app.controller;

import com.happen.happen_app.dto.TicketTypeDto;
import com.happen.happen_app.service.TicketTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketTypeController {

    private TicketTypeService ticketTypeService;

    public TicketTypeController(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @PostMapping
    public ResponseEntity<TicketTypeDto> addTicketType(@RequestBody TicketTypeDto ticketTypeDto) {
        return new ResponseEntity<>(ticketTypeService.createTicketType(ticketTypeDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketTypeDto> updateTicketType(@PathVariable Long id, @RequestBody TicketTypeDto ticketTypeDto) {
        return ResponseEntity.ok(ticketTypeService.updateTicketType(id, ticketTypeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicketType(@PathVariable Long id) {
        ticketTypeService.deleteTicketType(id);
        return ResponseEntity.ok("Ticket Type deleted successfully");
    }



    //    Get Methods
    @GetMapping("/{id}")
    public ResponseEntity<TicketTypeDto> getTicketTypeById(@PathVariable Long id) {
        TicketTypeDto ticketTypeDto = ticketTypeService.getTicketTypeById(id);
        return ResponseEntity.ok(ticketTypeDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketTypeDto>> getAllTicketTypes() {
        return ResponseEntity.ok(ticketTypeService.getAllTicketTypes());
    }


}