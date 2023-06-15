package com.agm.DietControlSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agm.DietControlSystem.model.entity.CategoryEntity;
import com.agm.DietControlSystem.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private CategoryRepository categoryRepository;
	
	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	//Simplemente para probar la conexión.
	
	@GetMapping("")
	public List<CategoryEntity> findAll() {
		
		return categoryRepository.findAll();
		
	}

}
