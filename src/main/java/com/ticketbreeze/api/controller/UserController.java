package com.ticketbreeze.api.controller;


import com.ticketbreeze.api.entity.User;
import com.ticketbreeze.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String indexPage(){ return "Welcome to my TicketBreeze API"; }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PutMapping("/update-user")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("delete-user/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }




}
