package com.agm.DietControlSystem.mapper.impl;

import org.springframework.stereotype.Component;

import com.agm.DietControlSystem.mapper.BrandEntityDTOMapper;
import com.agm.DietControlSystem.model.dto.BrandDTO;
import com.agm.DietControlSystem.model.entity.BrandEntity;

@Component
public class BrandEntityDTOMapperImpl implements BrandEntityDTOMapper {
	
	@Override
	public BrandDTO mapToDTO(BrandEntity entity) {
		BrandDTO dto = new BrandDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	public BrandEntity mapToEntity(BrandDTO dto) {
		BrandEntity entity = new BrandEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

}
