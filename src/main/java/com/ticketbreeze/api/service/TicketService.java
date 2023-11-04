package com.ticketbreeze.api.service;


import com.ticketbreeze.api.entity.Ticket;
import com.ticketbreeze.api.repository.EventRepository;
import com.ticketbreeze.api.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;


    public List<Ticket> getTicketsForEvent(int id){
        return repository.findByEventId(id);
    }

    public Ticket getTicketById(int eventID,int ticketID){

        Optional<Ticket> ticketOptional = repository.findByIdAndEventId(ticketID,eventID);

        if(ticketOptional.isPresent()){
            return ticketOptional.get();
        }else{
            throw new RuntimeException("Ticket not found with ID " + ticketID);
        }
    }
}
