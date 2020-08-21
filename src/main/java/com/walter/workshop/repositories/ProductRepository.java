package com.walter.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walter.workshop.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
