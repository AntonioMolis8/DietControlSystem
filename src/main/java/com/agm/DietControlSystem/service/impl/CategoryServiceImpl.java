package com.agm.DietControlSystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agm.DietControlSystem.mapper.CategoryEntityDTOMapper;
import com.agm.DietControlSystem.model.dto.CategoryDTO;
import com.agm.DietControlSystem.model.entity.CategoryEntity;
import com.agm.DietControlSystem.repository.CategoryRepository;
import com.agm.DietControlSystem.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryEntityDTOMapper categoryEntityDTOMapper;
	
	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> categories = new ArrayList<>();
		categories = categoryRepository.findAll().stream()
				.map((c) -> categoryEntityDTOMapper.mapToDTO(c)).collect(Collectors.toList());
		return categories;
	}

	@Override
	public CategoryDTO findById(Integer id) {
		Optional<CategoryEntity> category = categoryRepository.findById(id);
		
		return category.isPresent() ? categoryEntityDTOMapper.mapToDTO(category.get())
				: null;
	}

	@Override
	public CategoryDTO findByName(String name) {
		Optional<CategoryEntity> category = categoryRepository.findByName(name);
		
		return category.isPresent() ? categoryEntityDTOMapper.mapToDTO(category.get())
				: null;
	}

}
