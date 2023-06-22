package com.agm.DietControlSystem.mapper;

import com.agm.DietControlSystem.model.dto.BrandDTO;
import com.agm.DietControlSystem.model.entity.BrandEntity;

public interface BrandEntityDTOMapper {
	
	public BrandDTO mapToDTO(BrandEntity entity);
	public BrandEntity mapToEntity(BrandDTO dto);

}
