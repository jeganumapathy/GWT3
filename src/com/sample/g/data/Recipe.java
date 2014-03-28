package com.sample.g.data;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Recipe extends AbstractDatastore {

	public Recipe() {
	}

	@Id
	public  Long id;
	public String name;
	public String description;
	public String source;
	public FoodCatagories food_catagories;
	public boolean vegetarian;
	public String time_to_prepare;
	public String no_of_serving;
	public String calories;
	public String nutritions;
	public String instruction;
	public RecipeIngredient ingredient;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public FoodCatagories getFood_catagories() {
		return food_catagories;
	}

	public void setFood_catagories(FoodCatagories food_catagories) {
		this.food_catagories = food_catagories;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public String getTime_to_prepare() {
		return time_to_prepare;
	}

	public void setTime_to_prepare(String time_to_prepare) {
		this.time_to_prepare = time_to_prepare;
	}

	public String getNo_of_serving() {
		return no_of_serving;
	}

	public void setNo_of_serving(String no_of_serving) {
		this.no_of_serving = no_of_serving;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public String getNutritions() {
		return nutritions;
	}

	public void setNutritions(String nutritions) {
		this.nutritions = nutritions;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public RecipeIngredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(RecipeIngredient ingredient) {
		this.ingredient = ingredient;
	}

}
