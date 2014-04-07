package com.sample.g.data;

import java.util.List;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class RecipeIngredient extends AbstractDatastore {

	public RecipeIngredient() {
	}

	@Id
	public Long id;
	public String comments;

	public List<Ingredient> ingredientList;

	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


}
