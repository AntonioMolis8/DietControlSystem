package com.agm.DietControlSystem.mapper;

import com.agm.DietControlSystem.model.dto.CategoryDTO;
import com.agm.DietControlSystem.model.response.CategoryResponse;

public interface CategoryResponseDTOMapper {

	public CategoryResponse mapToResponse(CategoryDTO dto);
	public CategoryDTO mapToDTO(CategoryResponse response);
	
}
