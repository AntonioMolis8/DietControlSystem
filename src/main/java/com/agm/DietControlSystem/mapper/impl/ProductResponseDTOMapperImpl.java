package com.agm.DietControlSystem.mapper.impl;

import org.springframework.stereotype.Component;

import com.agm.DietControlSystem.mapper.ProductResponseDTOMapper;
import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.response.ProductResponse;

@Component
public class ProductResponseDTOMapperImpl implements ProductResponseDTOMapper{

	@Override
	public ProductDTO mapToDTO(ProductResponse request) {
		ProductDTO dto = new ProductDTO();
		dto.setId(request.getId());
		dto.setName(request.getName());
		dto.setCategory(request.getCategory());
		dto.setBrand(request.getBrand());
		dto.setCalories(request.getCalories());
		dto.setProteins(request.getProteins());
		dto.setReferenceQty(request.getReferenceQty());
		dto.setMeasureUnit(request.getMeasureUnit());
		return dto;
	}

	@Override
	public ProductResponse mapToResponse(ProductDTO dto) {
		ProductResponse request = new ProductResponse();
		request.setId(dto.getId());
		request.setName(dto.getName());
		request.setCategory(dto.getCategory());
		request.setBrand(dto.getBrand());
		request.setCalories(dto.getCalories());
		request.setProteins(dto.getProteins());
		request.setReferenceQty(dto.getReferenceQty());
		request.setMeasureUnit(dto.getMeasureUnit());
		return request;
	}
	
}
