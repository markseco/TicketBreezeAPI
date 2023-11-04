package com.ticketbreeze.api.repository;

import com.ticketbreeze.api.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {

}
