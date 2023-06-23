package com.agm.DietControlSystem.service;

import java.util.List;

import com.agm.DietControlSystem.model.dto.CategoryDTO;

public interface CategoryService {
	
	public List<CategoryDTO> findAll();
	public CategoryDTO findById(Integer id);
	public CategoryDTO findByName(String name);

}
