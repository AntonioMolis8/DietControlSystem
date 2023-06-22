package com.agm.DietControlSystem.mapper.impl;

import org.springframework.stereotype.Component;

import com.agm.DietControlSystem.mapper.CategoryResponseDTOMapper;
import com.agm.DietControlSystem.model.dto.CategoryDTO;
import com.agm.DietControlSystem.model.response.CategoryResponse;

@Component
public class CategoryResponseDTOMapperImpl implements CategoryResponseDTOMapper{

	@Override
	public CategoryResponse mapToResponse(CategoryDTO dto) {
		return new CategoryResponse(dto.getId(), dto.getName());
	}

	@Override
	public CategoryDTO mapToDTO(CategoryResponse response) {
		return new CategoryDTO(response.getId(), response.getName());
	}

}
