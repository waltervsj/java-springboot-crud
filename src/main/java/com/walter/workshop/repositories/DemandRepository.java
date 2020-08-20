package com.walter.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walter.workshop.entities.Demand;

public interface DemandRepository extends JpaRepository<Demand, Long> {

}
