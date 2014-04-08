package com.sample.g.server.service;

import static com.sample.g.server.service.OfyService.ofy;

import java.util.List;

import org.json.JSONArray;

import com.sample.g.data.AbstractDatastore;
import com.sample.g.data.FoodCatagories;
import com.sample.g.data.Ingredient;
import com.sample.g.data.JsonAnalyser;
import com.sample.g.data.Recipe;
import com.sample.g.data.RecipeIngredient;

public class RetriveService implements IService {

	private JsonService jsonService;
	public String result;
	public static int MAX_LIMIT = 250;

	public RetriveService(JsonService jsonService) {
		this.jsonService = jsonService;
	}

	@Override
	public Object doProcessing() {
		checkService();
		return readData(jsonService.abstractDatastore, MAX_LIMIT);
	}

	@Override
	public void checkService() {
		//check for max limit
		//get the start  and end limit
		//is the query is valid
	}

	public static Object readData(AbstractDatastore abstractDatastore,
			int limit) {
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
			JSONArray mArray = new JSONArray();
			mArray.put(c);
			return mArray;
		}
		return nBuilder.toString();
	}
}
