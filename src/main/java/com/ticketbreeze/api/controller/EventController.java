package com.ticketbreeze.api.controller;

import com.ticketbreeze.api.entity.Event;
import com.ticketbreeze.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/events")
    public List<Event> findAllEvents(){
        return service.getAllEvents();
    }

    @GetMapping("/event/{id}")
    public Event findEventById(@PathVariable int id){
        return service.getEventById(id);
    }

    @PostMapping("/add-event")
    public Event addEvent(@RequestBody Event event){

        return service.saveEvent(event);
    }

    @PutMapping("/update-event")
    public Event updateEvent(@RequestBody Event event){
        return service.updateEvent(event);
    }

    @DeleteMapping("/delete-event/{id}")
    public String deleteEvent(@PathVariable int id){
        return service.deleteEvent(id);
    }
}
