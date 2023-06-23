package com.agm.DietControlSystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agm.DietControlSystem.mapper.CategoryResponseDTOMapper;
import com.agm.DietControlSystem.model.response.CategoryResponse;
import com.agm.DietControlSystem.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryResponseDTOMapper categoryResponseDTOMapper;
	
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Operation(tags="Categories", summary = "Get all the categories")
	@GetMapping("")
	public List<CategoryResponse> findAll() {
		List<CategoryResponse> response = categoryService.findAll().stream()
				.map((c) -> categoryResponseDTOMapper.mapToResponse(c)).collect(Collectors.toList());
		
		return response;
	}
	
	@Operation(tags="Categories", summary = "Get a category by its id")
	@GetMapping("/{id}")
	public CategoryResponse findById(
			@Parameter(description = "Id of the category to be searched", example = "8")
			@PathVariable Integer id) {
		return categoryResponseDTOMapper.mapToResponse(categoryService.findById(id));
	}
	
	@Operation(tags="Categories", summary = "Get a category by its name")
	@GetMapping("/c/{name}")
	public CategoryResponse findByName(
			@Parameter(description = "Name of the category to be searched", example = "FRUTAS")
			@PathVariable String name) {
		return categoryResponseDTOMapper.mapToResponse(categoryService.findByName(name));
	}
	
	

}
