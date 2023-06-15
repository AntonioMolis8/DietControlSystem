package com.agm.DietControlSystem.mapper.impl;

import org.springframework.stereotype.Component;

import com.agm.DietControlSystem.mapper.ProductRequestDTOMapper;
import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.request.ProductRequest;

@Component
public class ProductRequestDTOMapperImpl implements ProductRequestDTOMapper{

	@Override
	public ProductDTO mapToDTO(ProductRequest request) {
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
	public ProductRequest mapToRequest(ProductDTO dto) {
		ProductRequest request = new ProductRequest();
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
