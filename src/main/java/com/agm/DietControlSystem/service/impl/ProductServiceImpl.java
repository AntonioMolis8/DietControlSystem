package com.agm.DietControlSystem.service.impl;

import java.util.ArrayList;
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
	public List<ProductDTO> findAllProducts() {
		List<ProductDTO> products = new ArrayList<>();
		products=productRepository.findAll().stream()
				.map((p) -> productEntityDTOMapper.mapToDTO(p)).collect(Collectors.toList());
		
		return products;
	}

}
