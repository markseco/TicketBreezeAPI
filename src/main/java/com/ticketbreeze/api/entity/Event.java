package com.ticketbreeze.api.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EVENT_TABLE")
public class Event {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Booking> bookingList = new ArrayList<>();
    private String name;
    private String description;
    private String location;
    private LocalDate date;
    private LocalTime time;
    private String genre;
    private int numberOfTickets;
    private float price;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Ticket> ticketList = new ArrayList<>();

    public void generateTickets(int numberOfTickets, float ticketPrice){
        for (int i = 1; i <= numberOfTickets; i++){
            Ticket ticket = new Ticket();
            ticket.setEvent(this);
            ticket.setSeatNumber(i);
            ticket.setStatus("Available");
            ticket.setPrice(ticketPrice);
            ticketList.add(ticket);
        }
    }

    public int availableSeats() {
        int count = 0;
        for (Ticket ticket : ticketList) {
            if ("Available".equals(ticket.getStatus())) {
                count++;
            }
        }
        return count;
    }


}
