package com.agm.DietControlSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agm.DietControlSystem.model.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	List<ProductEntity> findAll();
	
	List<ProductEntity> findProductById(Long id);
	
	List<ProductEntity> findProductByCategory (Integer category);

}
