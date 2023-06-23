package com.agm.DietControlSystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agm.DietControlSystem.mapper.ProductResponseDTOMapper;
import com.agm.DietControlSystem.model.response.ProductResponse;
import com.agm.DietControlSystem.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductResponseDTOMapper productResponseDTOMapper;
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@Operation(tags = "Products", summary = "Get all the products")
	@GetMapping("")
	public List<ProductResponse> findAllProducts() {
		 List<ProductResponse> response = productService.findAll().stream()
				.map((p) -> productResponseDTOMapper.mapToResponse(p)).collect(Collectors.toList());
		
		return response;
	}
	
	@Operation(tags = "Products", summary = "Get a product by its id")
	@GetMapping("/{id}")
	public ProductResponse findById(
			@Parameter(description = "Id of the product to be searched", example = "1") 
			@PathVariable Long id) {
		return productResponseDTOMapper.mapToResponse(productService.findById(id));
	}
	
	@Operation(tags = "Products", summary = "Get all products in a category")
	@GetMapping("/c/{categoryName}")
	public List<ProductResponse> findByCateory(
			@Parameter(description = "Name of the category which the products belong to", example = "PROTEINAS")
			@PathVariable String categoryName) {
		List<ProductResponse> response = productService.findProductsByCategory(categoryName).stream()
				.map((p) -> productResponseDTOMapper.mapToResponse(p)).collect(Collectors.toList());
		
		return response;
	}

}
