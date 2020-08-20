package com.walter.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.workshop.entities.Demand;
import com.walter.workshop.repositories.DemandRepository;

@Service
public class DemandService {
	@Autowired
	DemandRepository demandRepository;
	
	public List<Demand> findAll() {
		return demandRepository.findAll();
	}

	public Optional<Demand> findById(Long id) {
		return demandRepository.findById(id);
	}
}
