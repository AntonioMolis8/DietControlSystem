package com.agm.DietControlSystem.mapper.impl;

import com.agm.DietControlSystem.mapper.ProductEntityDTOMapper;
import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.entity.ProductEntity;

public class ProductEntityDTOMapperImpl implements ProductEntityDTOMapper{

	@Override
	public ProductDTO mapToDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
//		dto.setCategory(entity.getCategory());
//		dto.setBrand(entity.getBrand());
		dto.setCalories(entity.getCalories());
		dto.setProteins(entity.getProteins());
		dto.setReferenceQty(entity.getReferenceQty());
		dto.setMeasureUnit(entity.getMeasureUnit());
		return dto;
	}

	@Override
	public ProductEntity mapToEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
//		entity.setCategory(dto.getCategory());
//		entity.setBrand(dto.getBrand());
		entity.setCalories(dto.getCalories());
		entity.setProteins(dto.getProteins());
		entity.setReferenceQty(dto.getReferenceQty());
		entity.setMeasureUnit(dto.getMeasureUnit());
		return entity;
	}

}
