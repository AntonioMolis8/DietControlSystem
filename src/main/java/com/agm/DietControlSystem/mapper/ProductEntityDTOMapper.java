package com.agm.DietControlSystem.mapper;

import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.entity.BrandEntity;
import com.agm.DietControlSystem.model.entity.CategoryEntity;
import com.agm.DietControlSystem.model.entity.ProductEntity;

public interface ProductEntityDTOMapper {

	public ProductDTO mapToDTO (ProductEntity entity);
	public ProductEntity mapToEntity(ProductDTO product, CategoryEntity category, BrandEntity brand);
	
}
