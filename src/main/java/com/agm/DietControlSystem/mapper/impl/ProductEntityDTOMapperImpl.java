package com.agm.DietControlSystem.mapper.impl;

import org.springframework.stereotype.Component;

import com.agm.DietControlSystem.mapper.ProductEntityDTOMapper;
import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.entity.BrandEntity;
import com.agm.DietControlSystem.model.entity.CategoryEntity;
import com.agm.DietControlSystem.model.entity.ProductEntity;

@Component
public class ProductEntityDTOMapperImpl implements ProductEntityDTOMapper{
	
	public ProductEntityDTOMapperImpl() {
	}
	
	@Override
	public ProductDTO mapToDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCategory(entity.getCategory().getName());
		
		if(entity.getBrand() == null) {
			dto.setBrand("Genérico"); 
		} else {
			dto.setBrand(entity.getBrand().getName());
		}
		
		dto.setCalories(entity.getCalories());
		dto.setProteins(entity.getProteins());
		dto.setReferenceQty(entity.getReferenceQty());
		dto.setMeasureUnit(entity.getMeasureUnit());
		return dto;
	}

	@Override
	public ProductEntity mapToEntity(ProductDTO product, CategoryEntity category, BrandEntity brand) {
		ProductEntity entity = new ProductEntity();
		entity.setId(product.getId());
		entity.setName(product.getName());
		entity.setCategory(category);
		entity.setBrand(brand);
		entity.setCalories(product.getCalories());
		entity.setProteins(product.getProteins());
		entity.setReferenceQty(product.getReferenceQty());
		entity.setMeasureUnit(product.getMeasureUnit());
		return entity;
	}

}
