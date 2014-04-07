package com.sample.g.server.service;

import java.util.List;

import static com.sample.g.server.service.OfyService.ofy;
import com.sample.g.data.AbstractDatastore;
import com.sample.g.data.FoodCatagories;
import com.sample.g.data.Ingredient;
import com.sample.g.data.JsonAnalyser;
import com.sample.g.data.Recipe;
import com.sample.g.data.RecipeIngredient;

public class RetriveService implements IService {

	private JsonService jsonService;
	public String result;

	public RetriveService(JsonService jsonService) {
		this.jsonService = jsonService;
	}

	@Override
	public void doProcessing() {
		result=readData(jsonService.abstractDatastore, 10);
	}

	@Override
	public void checkService() {
	}

	public static String readData(AbstractDatastore abstractDatastore, int limit) {
		StringBuilder nBuilder = new StringBuilder();
		if (FOODCATAGORIES.equalsIgnoreCase(abstractDatastore.getApiName())) {
			List<FoodCatagories> c = ofy().load().type(FoodCatagories.class)
					.limit(limit).list();
			for (FoodCatagories foodCatagories : c) {
				nBuilder.append(JsonAnalyser.printJSON(foodCatagories));
			}

		} else if (INGREDIENT.equalsIgnoreCase(abstractDatastore.getApiName())) {
			List<Ingredient> c = ofy().load().type(Ingredient.class)
					.limit(limit).list();
			for (Ingredient foodCatagories : c) {
				nBuilder.append(JsonAnalyser.printJSON(foodCatagories));
			}
		} else if (RECIPEINGREDIENT.equalsIgnoreCase(abstractDatastore
				.getApiName())) {
			List<RecipeIngredient> c = ofy().load()
					.type(RecipeIngredient.class).limit(limit).list();
			for (RecipeIngredient foodCatagories : c) {
				nBuilder.append(JsonAnalyser.printJSON(foodCatagories));
			}
		} else if (RECIPE.equalsIgnoreCase(abstractDatastore.getApiName())) {
			List<Recipe> c = ofy().load().type(Recipe.class).limit(limit)
					.list();
			for (Recipe foodCatagories : c) {
				nBuilder.append(JsonAnalyser.printJSON(foodCatagories));
			}
		}
		return nBuilder.toString();
	}
}
