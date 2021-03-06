package com.walter.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walter.workshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
