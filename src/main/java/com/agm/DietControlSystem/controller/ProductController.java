package com.agm.DietControlSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agm.DietControlSystem.mapper.ProductResponseDTOMapper;
import com.agm.DietControlSystem.model.response.ProductResponse;
import com.agm.DietControlSystem.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductResponseDTOMapper productRequestDTOMapper;
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("")
	public List<ProductResponse> findAllProducts() {
		List<ProductResponse> response = new ArrayList<>();
		
		response = productService.findAllProducts().stream()
				.map((p) -> productRequestDTOMapper.mapToResponse(p)).collect(Collectors.toList());
		
		return response;
	}

}
