package com.agm.DietControlSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agm.DietControlSystem.model.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

	
//	ProductEntity findByName(String name);
	
	@Query(value = "SELECT * FROM Products WHERE category=(SELECT id FROM Categories WHERE name = :categoryName)", nativeQuery = true)
	List<ProductEntity> findByCategory (String categoryName);
	
	@Query(value = "SELECT * FROM Products WHERE proteins > :proteins", nativeQuery = true)
	List<ProductEntity> findProductsOverXProteins (Float proteins);
	
	

}
