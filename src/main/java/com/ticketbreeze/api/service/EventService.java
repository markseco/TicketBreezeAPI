package com.ticketbreeze.api.service;


import com.ticketbreeze.api.entity.Event;
import com.ticketbreeze.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents(){
        List<Event> events = repository.findAll();
        return events;
    }

    public Event getEventById(int id){
        return repository.findById(id).orElse(null);
    }

    public Event saveEvent(Event event){
        event.generateTickets(event.getNumberOfTickets(),event.getPrice());
        return repository.save(event);
    }

    public Event updateEvent(Event event){
        Event eventToUpdate = repository.findById(event.getId()).orElse(null);
        eventToUpdate.setName(event.getName());
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setLocation(event.getLocation());
        eventToUpdate.setDate(event.getDate());
        eventToUpdate.setTime(event.getTime());
        eventToUpdate.setGenre(event.getGenre());
        eventToUpdate.setPrice(event.getPrice());
        eventToUpdate.setNumberOfTickets(event.getNumberOfTickets());
        return repository.save(eventToUpdate);
    }

    public String deleteEvent(int id){
        repository.deleteById(id);
        return "event " + id + " removed";
    }


}
