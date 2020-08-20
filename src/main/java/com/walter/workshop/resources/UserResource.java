package com.walter.workshop.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walter.workshop.entities.User;
import com.walter.workshop.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}
	
}
