package com.agm.DietControlSystem.mapper;

import com.agm.DietControlSystem.model.dto.CategoryDTO;
import com.agm.DietControlSystem.model.entity.CategoryEntity;

public interface CategoryEntityDTOMapper {
	
	public CategoryDTO mapToDTO(CategoryEntity entity);
	public CategoryEntity mapToEntity(CategoryDTO dto);

}
