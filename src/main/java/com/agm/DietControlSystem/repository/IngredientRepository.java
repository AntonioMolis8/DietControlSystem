package com.agm.DietControlSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agm.DietControlSystem.model.entity.IngredientEntity;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

}
