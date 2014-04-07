package com.sample.g.server.service;

import static com.sample.g.server.service.OfyService.ofy;

import java.util.List;

import com.sample.g.data.FoodCatagories;
import com.sample.g.data.Ingredient;
import com.sample.g.data.Recipe;
import com.sample.g.data.RecipeIngredient;

public class DeleteService implements IService {

	private JsonService jsonService;

	public DeleteService(JsonService jsonService) {
		this.jsonService = jsonService;
	}


	@Override
	public void checkService() {
	}

	public void deleteAll() {
		deletFoodCatgories();
		deleteIngredient();
		deleteRecipe();
		deleteRecipeIngredient();
	}

	public void deletFoodCatgories() {
		List<FoodCatagories> foodCatagories = ofy().load()
				.type(FoodCatagories.class).list();
		for (FoodCatagories fc : foodCatagories) {
			ofy().delete().type(FoodCatagories.class).id(fc.getId()).now();
		}
	}

	public void deleteRecipe() {
		List<Recipe> recipes = ofy().load().type(Recipe.class).list();
		for (Recipe fc : recipes) {
			ofy().delete().type(Recipe.class).id(fc.getId()).now();
		}
	}

	public void deleteRecipeIngredient() {
		List<RecipeIngredient> recipeIngredients = ofy().load()
				.type(RecipeIngredient.class).list();
		for (RecipeIngredient fc : recipeIngredients) {
			ofy().delete().type(RecipeIngredient.class).id(fc.getId()).now();
		}
	}

	public void deleteIngredient() {
		List<Ingredient> ingredients = ofy().load().type(Ingredient.class)
				.list();
		for (Ingredient fc : ingredients) {
			ofy().delete().type(Ingredient.class).id(fc.getId()).now();
		}
	}


	@Override
	public Object doProcessing() {
		return null;
	}

}
