package com.agm.DietControlSystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agm.DietControlSystem.mapper.CategoryResponseDTOMapper;
import com.agm.DietControlSystem.model.dto.CategoryDTO;
import com.agm.DietControlSystem.model.response.CategoryResponse;
import com.agm.DietControlSystem.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Categories")
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryResponseDTOMapper categoryResponseDTOMapper;
	
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Operation(summary = "Get all the categories", description = "Returns all available categories")
	@ApiResponse(responseCode = "200", description = "Categories found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponse.class))})
	@GetMapping("")
	public List<CategoryResponse> findAll() {
		List<CategoryResponse> response = categoryService.findAll().stream()
				.map((c) -> categoryResponseDTOMapper.mapToResponse(c)).collect(Collectors.toList());
		
		return response;
	}
	
	
	@Operation(summary = "Get a category by its id", description = "Returns a single category")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Category found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponse.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Category not found", content = @Content)
	})
	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponse> findById(
			@Parameter(description = "Id of the category to be searched", example = "8")
			@PathVariable Integer id) {
		CategoryDTO category = categoryService.findById(id);
		
		return category == null ? ResponseEntity.notFound().build()
				: ResponseEntity.ok(categoryResponseDTOMapper.mapToResponse(category));
	}
	
	
	@Operation(summary = "Get a category by its name", description = "Returns a single category")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Category found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponse.class))}),
			@ApiResponse(responseCode = "404", description = "Category not found", content = @Content)
	})
	@GetMapping("/c/{name}")
	public ResponseEntity<CategoryResponse> findByName(
			@Parameter(description = "Name of the category to be searched", example = "FRUTAS")
			@PathVariable String name) {
		CategoryDTO category = categoryService.findByName(name);
		
		return category == null ? ResponseEntity.notFound().build()
				: ResponseEntity.ok(categoryResponseDTOMapper.mapToResponse(category));
	}
}