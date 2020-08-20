package com.walter.workshop.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walter.workshop.entities.Demand;
import com.walter.workshop.services.DemandService;

@RestController
@RequestMapping(value="/demands")
public class DemandResource {

	@Autowired
	DemandService demandService;
	
	@GetMapping
	public ResponseEntity<List<Demand>> findAll() {
		return ResponseEntity.ok(demandService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Demand>> findById(@PathVariable Long id) {
		return ResponseEntity.ok(demandService.findById(id));
	}
}
