package com.agm.DietControlSystem.mapper;

import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.request.ProductRequest;

public interface ProductRequestDTOMapper {
	
	public ProductDTO mapToDTO(ProductRequest request);
	public ProductRequest mapToRequest(ProductDTO dto);

}
