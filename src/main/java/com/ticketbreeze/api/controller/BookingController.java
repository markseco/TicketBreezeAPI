package com.ticketbreeze.api.controller;


import com.ticketbreeze.api.entity.Booking;
import com.ticketbreeze.api.entity.Event;
import com.ticketbreeze.api.entity.User;
import com.ticketbreeze.api.service.BookingService;
import com.ticketbreeze.api.service.EventService;
import com.ticketbreeze.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private BookingService service;
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;

    @GetMapping("/user/{userID}/bookings")
    public List<Booking> findBookingsForUser(@PathVariable int userID){
        return service.getBookingsByUserId(userID);
    }

    @GetMapping("/user/{userID}/bookings/{bookingID}")
    public List<Booking> findBooking(@PathVariable int bookingID){
        return service.getBookingById(bookingID);
    }

    @PostMapping("/event/{eventID}/new-booking/{userID}")
    public Booking addBooking(@RequestBody Booking booking, @PathVariable int eventID, @PathVariable int userID) throws Exception {
        Event event = eventService.getEventById(eventID);
        User user = userService.getUserById(userID);
        if (event != null) {
            booking.setEvent(event);
            booking.setUser(user);
            return service.saveBooking(booking);
        } else {
            throw new Exception("Event with ID " + eventID + " not found");
        }
    }

    @DeleteMapping("/user/{userID}/delete-booking/{bookingID}")
    public String deleteBooking(@PathVariable int bookingID) throws Exception {
        return service.deleteBooking(bookingID);
    }

}
