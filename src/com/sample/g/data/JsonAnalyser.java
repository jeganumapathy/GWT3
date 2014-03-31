package com.sample.g.data;

import com.google.gson.Gson;

public class JsonAnalyser {
	public static Gson gson = new Gson();

	public static String printJSON(AbstractDatastore dataStore) {
		String json = "-";
		if (dataStore instanceof FoodCatagories) {
			FoodCatagories obj = (FoodCatagories) dataStore;
			json = gson.toJson(obj);
		} else if (dataStore instanceof Ingredient) {
			Ingredient obj = (Ingredient) dataStore;
			json = gson.toJson(obj);
		} else if (dataStore instanceof Recipe) {
			Recipe obj = (Recipe) dataStore;
			json = gson.toJson(obj);
		} else if (dataStore instanceof RecipeIngredient) {
			RecipeIngredient obj = (RecipeIngredient) dataStore;
			json = gson.toJson(obj);
		}
		return json;
	}
}
