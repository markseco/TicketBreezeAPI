package com.ticketbreeze.api.repository;

import com.ticketbreeze.api.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findReviewsByEventId(int eventId);
}
