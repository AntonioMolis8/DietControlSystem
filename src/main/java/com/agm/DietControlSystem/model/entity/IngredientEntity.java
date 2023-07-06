package com.agm.DietControlSystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Ingredients")
public class IngredientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;
	
	@NotNull
	@Column(name = "quantity")
	private Float quantity;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meal_id", referencedColumnName = "id")
	private MealEntity meal;

	public IngredientEntity() {}

	public IngredientEntity(Long id, ProductEntity product, Float quantity, MealEntity meal) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.meal = meal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public MealEntity getMeal() {
		return meal;
	}

	public void setMeal(MealEntity meal) {
		this.meal = meal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IngredientEntity [id=");
		builder.append(id);
		builder.append(", product=");
		builder.append(product);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", meal=");
		builder.append(meal);
		builder.append("]");
		return builder.toString();
	}

}
