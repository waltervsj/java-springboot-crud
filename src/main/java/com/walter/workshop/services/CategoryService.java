package com.walter.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walter.workshop.entities.Category;
import com.walter.workshop.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll(); 
	}
	
	public Category findById(Long id) {
		return categoryRepository.findById(id).get();
	}
}
