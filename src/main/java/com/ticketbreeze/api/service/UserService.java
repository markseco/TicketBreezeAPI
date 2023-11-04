package com.ticketbreeze.api.service;


import com.ticketbreeze.api.entity.User;
import com.ticketbreeze.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers(){
        List<User> users = repository.findAll();
        return users;
    }

    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }

    public User saveUser(User user){
        return repository.save(user);
    }

    public User updateUser(User user){
        User userToUpdate = repository.findById(user.getId()).orElse(null);
        userToUpdate.setRole(user.getRole());
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        return repository.save(userToUpdate);
    }

    public String deleteUser(int id){
        repository.deleteById(id);
        return "user " + id + " removed";
    }

}
