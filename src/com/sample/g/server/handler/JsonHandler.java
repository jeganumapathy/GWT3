package com.sample.g.server.handler;

import com.google.gson.Gson;
import com.sample.g.data.AbstractDatastore;
import com.sample.g.data.Constants;
import com.sample.g.data.FoodCatagories;
import com.sample.g.data.Ingredient;
import com.sample.g.data.OfyService;

public class JsonHandler implements Constants {
	Gson gson = null;

	public JsonHandler() {
		gson = new Gson();
	}

	public void onHandle(String json) {
		// Need to analys a different way
		AbstractDatastore abstractDatastore = gson.fromJson(json,
				AbstractDatastore.class);
		if (FOODCATAGORIES.equalsIgnoreCase(abstractDatastore.getApiName())) {
			abstractDatastore = gson.fromJson(json, FoodCatagories.class);
		} else if (INGREDIENT.equalsIgnoreCase(abstractDatastore.getApiName())) {
			abstractDatastore = gson.fromJson(json, Ingredient.class);
		} else if (RECIPEINGREDIENT.equalsIgnoreCase(abstractDatastore
				.getApiName())) {
			abstractDatastore = gson.fromJson(json, Ingredient.class);
		} else if (RECIPE.equalsIgnoreCase(abstractDatastore.getApiName())) {
			abstractDatastore = gson.fromJson(json, Ingredient.class);
		}
		OfyService.store(abstractDatastore);
	}
}
