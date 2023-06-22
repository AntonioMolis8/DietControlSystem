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
@Table(name = "Products")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category", referencedColumnName = "id")
	private CategoryEntity category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand", referencedColumnName = "id")
	private BrandEntity brand;
	
	@NotNull
	@Column(name = "calories")
	private Integer calories;
	
	@NotNull
	@Column(name = "proteins")
	private Integer proteins;
	
	@NotNull
	@Column(name = "referenceqty")
	private Integer referenceQty;
	
	@NotNull
	@Column(name = "measureunit")
	private String measureUnit;
	
	public ProductEntity() {}

	public ProductEntity(String name, CategoryEntity category, BrandEntity brand, Integer calories, 
			Integer proteins, Integer referenceQty, String measureUnit) {
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.calories = calories;
		this.proteins = proteins;
		this.referenceQty = referenceQty;
		this.measureUnit = measureUnit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getProteins() {
		return proteins;
	}

	public void setProteins(Integer proteins) {
		this.proteins = proteins;
	}

	public Integer getReferenceQty() {
		return referenceQty;
	}

	public void setReferenceQty(Integer referenceQty) {
		this.referenceQty = referenceQty;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductEntity [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", category=");
		builder.append(category);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", calories=");
		builder.append(calories);
		builder.append(", proteins=");
		builder.append(proteins);
		builder.append(", referenceQty=");
		builder.append(referenceQty);
		builder.append(", measureUnit=");
		builder.append(measureUnit);
		builder.append("]");
		return builder.toString();
	};
		
}


