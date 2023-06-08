package com.agm.DietControlSystem.mapper.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.agm.DietControlSystem.mapper.ProductEntityDTOMapper;
import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.entity.ProductEntity;

@Component
public class ProductEntityDTOMapperImpl implements ProductEntityDTOMapper{

	private ArrayList<String> categories;
	private ArrayList<String> brands;
	
	public ProductEntityDTOMapperImpl() {
		setUpCategories();
		setUpBrands();
	}
	
	@Override
	public ProductDTO mapToDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCategory(categories.get(entity.getCategory().intValue()));
		dto.setBrand(brands.get(entity.getBrand().intValue()));
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
		entity.setCategory(Integer.valueOf(categories.indexOf(dto.getCategory())));
		entity.setBrand(Integer.valueOf(brands.indexOf(dto.getBrand())));
		entity.setCalories(dto.getCalories());
		entity.setProteins(dto.getProteins());
		entity.setReferenceQty(dto.getReferenceQty());
		entity.setMeasureUnit(dto.getMeasureUnit());
		return entity;
	}
	
	private ArrayList<String> setUpCategories () {
		categories = new ArrayList<>();
		categories.add("");
		categories.add("PROTEINAS");
		categories.add("HIDRATOS");
		categories.add("VERDURAS Y HORTALIZAS");
		categories.add("LEGUMBRES");
		categories.add("FRUTAS");
		categories.add("LECHES");
		categories.add("YOGURES Y POSTRES");
		categories.add("QUESOS");
		categories.add("CEREALES");
		categories.add("PAN");
		categories.add("EMBUTIDOS");
		categories.add("ACEITES");
		categories.add("ENCURTIDOS");
		categories.add("FRUTOS SECOS");
		categories.add("GALLETAS Y SNACKS");
		categories.add("SALSAS");
		categories.add("OTROS");
		return categories;
	}
	
	private ArrayList<String> setUpBrands() {
		brands = new ArrayList<>();
		categories.add("");
		brands.add("HACENDADO");
		return brands;
	}

}
