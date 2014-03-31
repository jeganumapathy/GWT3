package com.sample.g.data;

import org.json.JSONObject;

import com.google.gson.Gson;

public class JsonAnalyser {
	public static Gson gson = new Gson();

	public static String printJSON(AbstractDatastore dataStore) {
		JSONObject jsonObject = null;
		String json = "-";
		if (dataStore instanceof FoodCatagories) {
			FoodCatagories obj = (FoodCatagories) dataStore;
			jsonObject = new JSONObject(obj);
			json = gson.toJson(obj);
		} else if (dataStore instanceof Ingredient) {
			Ingredient obj = (Ingredient) dataStore;
			jsonObject = new JSONObject(obj);
			json = gson.toJson(obj);

		} else if (dataStore instanceof Recipe) {
			Recipe obj = (Recipe) dataStore;
			jsonObject = new JSONObject(obj);
			json = gson.toJson(obj);
		} else if (dataStore instanceof RecipeIngredient) {
			RecipeIngredient obj = (RecipeIngredient) dataStore;
			jsonObject = new JSONObject(obj);
			json = gson.toJson(obj);
		}
		return json;
	}
}
