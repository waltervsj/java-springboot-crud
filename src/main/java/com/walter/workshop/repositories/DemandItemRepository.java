package com.walter.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walter.workshop.entities.DemandItem;
import com.walter.workshop.entities.pk.DemandItemPK;

public interface DemandItemRepository extends JpaRepository<DemandItem, DemandItemPK>{

}
