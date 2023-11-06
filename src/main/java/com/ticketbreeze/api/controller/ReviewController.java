package com.ticketbreeze.api.controller;


import com.ticketbreeze.api.entity.Review;
import com.ticketbreeze.api.service.EventService;
import com.ticketbreeze.api.service.ReviewService;
import com.ticketbreeze.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService service;
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @GetMapping("/event/{eventId}/reviews")
    public List<Review> findReviewsForEvent(@PathVariable int eventId){
        return service.getReviewsByEventId(eventId);
    }

    @GetMapping("/event/{eventId}/review/{reviewId}")
    public Review findReview(@PathVariable int reviewId){
        return service.getReviewById(reviewId);
    }

    @PostMapping("/event/{eventId}/review/{userId}")
    public Review addNewReview(@RequestBody Review review, @PathVariable int eventId, @PathVariable int userId){
        review.setEvent(eventService.getEventById(eventId));
        review.setUser(userService.getUserById(userId));
        return service.saveReview(review);
    }

    @PutMapping("/update-review/{reviewId}")
    public Review updateReview(@PathVariable int reviewId, @RequestBody Review review) throws Exception {
        return service.updateReview(reviewId, review);
    }

    @DeleteMapping("/delete-review/{reviewId}")
    public String deleteReview(@PathVariable int reviewId) throws Exception{
        return service.deleteReview(reviewId);
    }
}
