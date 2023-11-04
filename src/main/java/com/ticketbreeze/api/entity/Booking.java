package com.ticketbreeze.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "BOOKING_TABLE")
public class Booking {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("booking-tickets")
    private List<Ticket> ticketList = new ArrayList<>();

    private LocalDateTime localDateTime;
    private int numberOfParticipants;
    private float totalPrice;

    @PrePersist
    public void calculateTotalPrice() {
        float total = 0.0f;
        for (Ticket ticket : ticketList) {
            total += ticket.getPrice();
        }
        this.totalPrice = total;
    }

}
