package com.agm.DietControlSystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agm.DietControlSystem.mapper.ProductResponseDTOMapper;
import com.agm.DietControlSystem.model.dto.ProductDTO;
import com.agm.DietControlSystem.model.response.ProductResponse;
import com.agm.DietControlSystem.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Products")
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductResponseDTOMapper productResponseDTOMapper;
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@Operation(summary = "Get all the products", description = "Returns a list with all the products")
	@ApiResponse(responseCode = "200", description = "Products found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))})
	@GetMapping("")
	public List<ProductResponse> findAllProducts() {
		 List<ProductResponse> response = productService.findAll().stream()
				.map((p) -> productResponseDTOMapper.mapToResponse(p)).collect(Collectors.toList());
		
		return response;
	}
	
	
	@Operation(summary = "Get a product by its id", description = "Returns a single product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Product not found" , content = @Content)
	})
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> findById(
			@Parameter(description = "Id of the product to be searched", example = "1") 
			@PathVariable Long id) {
		ProductDTO product = productService.findById(id);
		
		return product == null ? ResponseEntity.notFound().build() 
				: ResponseEntity.ok(productResponseDTOMapper.mapToResponse(product));
	}
	
	
	@Operation(summary = "Get all products in a category", description = "Returns a list of products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Products found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))}),
			@ApiResponse(responseCode = "404", description = "No product found since category doesn't exist" , content = @Content)
	})
	@GetMapping("/c/{categoryName}")
	public ResponseEntity<List<ProductResponse>> findByCateory(
			@Parameter(description = "Name of the category which the products belong to", example = "PROTEINAS")
			@PathVariable String categoryName) {
		List<ProductDTO> products = productService.findProductsByCategory(categoryName);
		
		return products.isEmpty() ? ResponseEntity.notFound().build()
				: ResponseEntity.ok(products.stream().map((p) -> productResponseDTOMapper.mapToResponse(p)).collect(Collectors.toList()));
	}  
	
	
//	Just to use @ResquestParam (because the quantity of proteins is more like a filter) and manage empty lists.
	@Operation(summary = "Get all products that have more proteins than specified", description = "Return a list of products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the products", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))}),
			@ApiResponse(responseCode = "204", description = "There are no products that match the filter" , content = @Content),
			@ApiResponse(responseCode = "400", description = "Invalid quantity of proteins supplied", content = @Content)
	})
	@GetMapping("/p")
	public ResponseEntity<List<ProductResponse>> findProductOverXProteins(
			@Parameter(description = "Minimum proteins of the product", example = "20")
			@RequestParam  Float proteins) {
		
		List<ProductDTO> products = productService.findProductsOverXProteins(proteins);
		
		return products.isEmpty() ? ResponseEntity.noContent().build()
				: ResponseEntity.ok(products.stream()
						.map((p) -> productResponseDTOMapper.mapToResponse(p)).collect(Collectors.toList()));
	}
}