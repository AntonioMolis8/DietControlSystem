package com.agm.DietControlSystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agm.DietControlSystem.mapper.ProductEntityDTOMapper;
import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.entity.ProductEntity;
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
		Optional<ProductEntity> product = productRepository.findById(id);
		
		return product.isPresent() ? productEntityDTOMapper.mapToDTO(product.get())
				: null;
	}

	@Override
	public List<ProductDTO> findProductsByCategory(String categoryName) {
		List<ProductDTO> products = productRepository.findByCategory(categoryName).stream()
				.map((p) -> productEntityDTOMapper.mapToDTO(p)).collect(Collectors.toList());
		
		return products;
	}
	
	@Override
	public List<ProductDTO> findProductsOverXProteins(Float proteins) {
		List<ProductDTO> products = productRepository.findProductsOverXProteins(proteins).stream()
				.map((p) -> productEntityDTOMapper.mapToDTO(p)).collect(Collectors.toList());
		
		return products;
	}

}
