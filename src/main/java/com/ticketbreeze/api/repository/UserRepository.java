package com.ticketbreeze.api.repository;

import com.ticketbreeze.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
