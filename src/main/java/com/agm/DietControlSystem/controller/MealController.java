package com.agm.DietControlSystem.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agm.DietControlSystem.model.entity.MealEntity;
import com.agm.DietControlSystem.repository.MealRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Meals")
@RequestMapping("/api/meals")
public class MealController {
	
	private MealRepository mealRepository;
	
	public MealController(MealRepository mealRepository) {
		this.mealRepository = mealRepository;
	}
	
	@GetMapping("")
	public List<MealEntity> findAll () {
		return mealRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public MealEntity findById(@PathVariable Integer id) {
		return mealRepository.findById(id).get();
	}
	
	@PostMapping("")
	public ResponseEntity<MealEntity> create (@RequestBody MealEntity meal) {		
		if (meal.getId() != null) {
			return ResponseEntity.badRequest().build();
		}
		MealEntity response = mealRepository.save(meal);
		return ResponseEntity.created(URI.create("/api/meals/" + response.getId())).build();
	}
}
