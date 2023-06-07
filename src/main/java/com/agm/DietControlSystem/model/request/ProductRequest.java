package com.agm.DietControlSystem.model.request;

public class ProductRequest {
	
	private Long id;
	private String name;
	private String category;
	private String brand;
	private Float calories;
	private Float proteins;
	private Integer referenceQty;
	private String measureUnit;
	
	public ProductRequest() {}

	public ProductRequest(Long id, String name, String category, String brand, Float calories, Float proteins,
			Integer referenceQty, String measureUnit) {
		this.id = id;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
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
		builder.append("ProductDTO [id=");
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
