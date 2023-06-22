package com.agm.DietControlSystem.mapper;

import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.response.ProductResponse;

public interface ProductResponseDTOMapper {
	
	public ProductDTO mapToDTO(ProductResponse request);
	public ProductResponse mapToResponse(ProductDTO dto);

}
