package com.ticketbreeze.api.service;


import com.ticketbreeze.api.entity.Review;
import com.ticketbreeze.api.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    public Review getReviewById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Review> getReviewsByEventId(int eventid){
        List<Review> reviewList = repository.findReviewsByEventId(eventid);
        if (!reviewList.isEmpty()) {
            return reviewList;
        } else {
            throw new RuntimeException("No reviews found for the event with ID: " + eventid);
        }
    }

    public Review saveReview(Review review){
        review.setLocalDateTime(LocalDateTime.now());
        return repository.save(review);
    }

    public Review updateReview(int reviewId, Review review) throws Exception {
        Review reviewToUpdate = repository.findById(reviewId).orElse(null);
        if(reviewToUpdate != null){
            reviewToUpdate.setComment(review.getComment());
            reviewToUpdate.setRating(review.getRating());
            reviewToUpdate.setLocalDateTime(LocalDateTime.now());
            return repository.save(reviewToUpdate);
        }
        throw new Exception("Review Not Found");
    }

    public String deleteReview(int reviewId) throws Exception{
        Review reviewToDelete = repository.findById(reviewId).orElse(null);
        if(reviewToDelete != null){
            repository.deleteById(reviewId);
            return "Review with ID = " + reviewId + " deleted";
        }
        throw new Exception("Review Not Found");
    }
}
