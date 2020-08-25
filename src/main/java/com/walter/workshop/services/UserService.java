package com.walter.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.workshop.entities.User;
import com.walter.workshop.exceptions.ResourceNotFoundException;
import com.walter.workshop.repositories.UserRepository;

import javassist.NotFoundException;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public User update(Long id, User user) {
		User updateUser = userRepository.getOne(id);
		updateUser.clone(user);
		return userRepository.save(updateUser);
	}
}
