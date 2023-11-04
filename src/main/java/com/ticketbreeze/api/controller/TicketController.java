package com.ticketbreeze.api.controller;


import com.ticketbreeze.api.entity.Ticket;
import com.ticketbreeze.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping("/event/{eventID}/tickets")
    public List<Ticket> findTicketsForEvent(@PathVariable int eventID){
        return service.getTicketsForEvent(eventID);
    }

    @GetMapping("/event/{eventID}/tickets/{ticketID}")
    public Ticket findTicketById(@PathVariable int eventID, @PathVariable int ticketID){
        return service.getTicketById(eventID, ticketID);
    }
}
