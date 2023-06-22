package com.agm.DietControlSystem.mapper.impl;

import org.springframework.stereotype.Component;

import com.agm.DietControlSystem.mapper.CategoryEntityDTOMapper;
import com.agm.DietControlSystem.model.dto.CategoryDTO;
import com.agm.DietControlSystem.model.entity.CategoryEntity;

@Component
public class CategoryEntityDTOMapperImpl implements CategoryEntityDTOMapper {

	@Override
	public CategoryDTO mapToDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	public CategoryEntity mapToEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

}