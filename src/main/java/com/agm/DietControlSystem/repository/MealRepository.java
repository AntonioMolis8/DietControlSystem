package com.agm.DietControlSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agm.DietControlSystem.model.entity.MealEntity;

public interface MealRepository extends JpaRepository<MealEntity, Integer>{

}
