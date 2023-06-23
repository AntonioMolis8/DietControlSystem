package com.agm.DietControlSystem.service;

import java.util.List;

import com.agm.DietControlSystem.model.dto.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> findAll();
	public ProductDTO findById(Long id);
	public List<ProductDTO> findProductsByCategory(String category);

}
