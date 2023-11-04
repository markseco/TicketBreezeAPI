package com.ticketbreeze.api.repository;

import com.ticketbreeze.api.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
    List<Booking> findByUserId(int userId);
}
