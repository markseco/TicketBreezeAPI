package com.ticketbreeze.api.repository;

import com.ticketbreeze.api.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findByEventId(int eventId);
    Optional<Ticket> findByIdAndEventId(int id, int eventId);
}
