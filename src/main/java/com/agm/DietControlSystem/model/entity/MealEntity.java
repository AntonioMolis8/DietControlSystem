package com.agm.DietControlSystem.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Meals")
public class MealEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "type")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type", referencedColumnName = "id")
	private TypeOfMealEntity type;
	
	@Column(name = "isFavourite")
	private Boolean isFavourite;
	
	@Column(name = "totalCalories")
	private Integer totalCalories;
	
	@Column(name = "totalProteins")
	private Integer totalProteins;
	
	@Column(name = "dateOfMeal")
	private LocalDateTime dateOfMeal;
	
	@OneToMany(mappedBy = "meal")
	private List<IngredientEntity> ingredients;

	public MealEntity() {}

	public MealEntity(Integer id, String name, TypeOfMealEntity type, Boolean isFavourite, Integer totalCalories, Integer totalProteins, LocalDateTime dateOfMeal) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.isFavourite = isFavourite;
		this.totalCalories = totalCalories;
		this.totalProteins = totalProteins;
		this.dateOfMeal = dateOfMeal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeOfMealEntity getType() {
		return type;
	}

	public void setType(TypeOfMealEntity type) {
		this.type = type;
	}

	public Boolean getIsFavourite() {
		return isFavourite;
	}

	public void setIsFavourite(Boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	public Integer getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(Integer totalCalories) {
		this.totalCalories = totalCalories;
	}

	public Integer getTotalProteins() {
		return totalProteins;
	}

	public void setTotalProteins(Integer totalProteins) {
		this.totalProteins = totalProteins;
	}

	public LocalDateTime getDateOfMeal() {
		return dateOfMeal;
	}

	public void setDateOfMeal(LocalDateTime dateOfMeal) {
		this.dateOfMeal = dateOfMeal;
	}

	public List<IngredientEntity> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientEntity> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MealEntity [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", isFavourite=");
		builder.append(isFavourite);
		builder.append(", totalCalories=");
		builder.append(totalCalories);
		builder.append(", totalProteins=");
		builder.append(totalProteins);
		builder.append(", dateOfMeal=");
		builder.append(dateOfMeal);
		builder.append("]");
		return builder.toString();
	}	

}
