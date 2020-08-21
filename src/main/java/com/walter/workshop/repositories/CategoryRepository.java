package com.walter.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walter.workshop.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
