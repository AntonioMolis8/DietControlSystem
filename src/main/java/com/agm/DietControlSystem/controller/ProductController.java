package com.agm.DietControlSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agm.DietControlSystem.mapper.ProductRequestDTOMapper;
import com.agm.DietControlSystem.model.request.ProductRequest;
import com.agm.DietControlSystem.service.ProductService;

@RestController
@RequestMapping("")
public class ProductController {
	
	@Autowired
	private ProductRequestDTOMapper productRequestDTOMapper;
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public List<ProductRequest> findAllProducts() {
		List<ProductRequest> response = new ArrayList<>();
		
		response = productService.findAllProducts().stream()
				.map((p) -> productRequestDTOMapper.mapToRequest(p)).collect(Collectors.toList());
		
		return response;
	}

}
