package com.ticketbreeze.api.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TABLE")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("user-reviews")
    private List<Review> reviewList = new ArrayList<>();
    private String username;
    private String password;
    private String email;
    private String name;
    private int phoneNumber;
    //Role should be either customer or admin
    private String role;
}
