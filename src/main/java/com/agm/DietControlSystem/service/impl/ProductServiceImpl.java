package com.agm.DietControlSystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agm.DietControlSystem.mapper.ProductEntityDTOMapper;
import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.repository.ProductRepository;
import com.agm.DietControlSystem.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductEntityDTOMapper productEntityDTOMapper;
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> products=productRepository.findAll().stream()
				.map((p) -> productEntityDTOMapper.mapToDTO(p)).collect(Collectors.toList());
		
		return products;
	}
	
	@Override
	public ProductDTO findById(Long id) {
		return productEntityDTOMapper.mapToDTO(productRepository.findById(id).get());
	}

	@Override
	public List<ProductDTO> findProductsByCategory(String categoryName) {
		List<ProductDTO> products = productRepository.findByCategory(categoryName).stream()
				.map((p) -> productEntityDTOMapper.mapToDTO(p)).collect(Collectors.toList());
		
		return products;
	}

}
