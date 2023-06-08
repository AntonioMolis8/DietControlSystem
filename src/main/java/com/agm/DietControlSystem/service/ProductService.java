package com.agm.DietControlSystem.service;

import java.util.List;

import com.agm.DietControlSystem.model.dto.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> findAllProducts();
//	public List<ProductDTO> findProduct(ProductDTO productDTO);
//	public List<ProductDTO> findProductByCategory(String category);

}
