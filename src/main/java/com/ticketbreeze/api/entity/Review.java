package com.ticketbreeze.api.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REVIEW_TABLE")
public class Review {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference("event-reviews")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-reviews")
    private User user;

    private float rating;
    private String comment;
    private LocalDateTime localDateTime;


}
