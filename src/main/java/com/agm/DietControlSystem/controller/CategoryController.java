package com.agm.DietControlSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agm.DietControlSystem.mapper.CategoryResponseDTOMapper;
import com.agm.DietControlSystem.model.response.CategoryResponse;
import com.agm.DietControlSystem.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryResponseDTOMapper categoryResponseDTOMapper;
	
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("")
	public List<CategoryResponse> findAll() {
		List<CategoryResponse> response = new ArrayList<>();
		
		response = categoryService.findAll().stream()
				.map((c) -> categoryResponseDTOMapper.mapToResponse(c)).collect(Collectors.toList());
		
		return response;
	}

}
