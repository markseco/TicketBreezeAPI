package com.ticketbreeze.api.service;

import com.ticketbreeze.api.entity.Booking;
import com.ticketbreeze.api.entity.Ticket;
import com.ticketbreeze.api.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    public List<Booking> getBookingsByUserId(int userId) {
        List<Booking> bookings = repository.findByUserId(userId);
        if (!bookings.isEmpty()) {
            return bookings;
        } else {
            throw new RuntimeException("No bookings found for user with ID: " + userId);
        }
    }

    public List<Booking> getBookingById(int bookingId){
        return repository.findById(bookingId).stream().toList();
    }

    public Booking saveBooking(Booking booking) throws Exception {
        //check for seat availability
        if(booking.getNumberOfParticipants() > booking.getEvent().availableSeats()){
            throw new Exception("Sorry, no seats are available at this moment for this event. ");
        }
        booking.calculateTotalPrice();
        booking.setLocalDateTime(LocalDateTime.now());

        // Find and assign "Available" tickets in the event
        List<Ticket> availableTickets = booking.getEvent().getTicketList().stream()
                .filter(ticket -> ticket.getStatus().equals("Available"))
                .limit(booking.getNumberOfParticipants())
                .toList();

        if (availableTickets.size() < booking.getNumberOfParticipants()) {
            throw new Exception("Not enough available tickets for this booking.");
        }

        // Assign tickets to the booking and set their status as "Occupied"
        for (Ticket ticket : availableTickets) {
            ticket.setStatus("Occupied");
            ticket.setBooking(booking);
        }
        booking.setTicketList(availableTickets);

        return repository.save(booking);
    }

    public String deleteBooking(int bookingId) throws Exception {
        //set tickets to available
        Optional<Booking> bookingToDelete = repository.findById(bookingId);
        if(bookingToDelete.isPresent()){
            for (Ticket ticket : bookingToDelete.get().getTicketList()) {
                ticket.setStatus("Available");
                repository.deleteById(bookingId);
                return "booking " + bookingId + " removed";
            }
        }
        throw new Exception("Booking Not Found");
    }
}
