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
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "category")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Categories_id", referencedColumnName = "id")
	private Integer category;
	
	@Column(name = "brand")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Brands_id", referencedColumnName = "id")
	private Integer brand;
	
	@NotNull
	@Column(name = "calories")
	private Float calories;
	
	@NotNull
	@Column(name = "proteins")
	private Float proteins;
	
	@NotNull
	@Column(name = "referenceQty")
	private Integer referenceQty;
	
	@NotNull
	@Column(name = "measureUnit")
	private String measureUnit;
	
	public Product() {};

	public Product(String name, Integer category, Integer brand, Float calories, Float proteins, Integer referenceQty,
			String measureUnit) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	public Float getCalories() {
		return calories;
	}

	public void setCalories(Float calories) {
		this.calories = calories;
	}

	public Float getProteins() {
		return proteins;
	}

	public void setProteins(Float proteins) {
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
		builder.append("Product [id=");
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
	}
	
}


