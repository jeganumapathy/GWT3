package com.sample.g.server.handler;

import com.google.gson.Gson;
import com.sample.g.data.AbstractDatastore;
import com.sample.g.data.Constants;
import com.sample.g.data.FoodCatagories;
import com.sample.g.data.Ingredient;
import com.sample.g.data.OfyService;
import com.sample.g.data.Recipe;
import com.sample.g.data.RecipeIngredient;
import com.sample.g.server.ApiServlet;
import com.sample.g.server.BaseHttpServlet;
import com.sample.g.server.DeleteApiServelet;
import com.sample.g.server.RetriveApiServlet;

public class JsonHandler implements Constants {
	Gson gson = null;
	BaseHttpServlet basehttpservlet;
	AbstractHandler abstractHandler;

	public JsonHandler(BaseHttpServlet basehttpservlet,
			AbstractHandler abstractHandler) {
		this.basehttpservlet = basehttpservlet;
		this.abstractHandler = abstractHandler;
		gson = new Gson();
	}

	public void onHandle(String json) {
		AbstractDatastore abstractDatastore = gson.fromJson(json,
				AbstractDatastore.class);
		if (FOODCATAGORIES.equalsIgnoreCase(abstractDatastore.getApiName())) {
			abstractDatastore = gson.fromJson(json, FoodCatagories.class);
		} else if (INGREDIENT.equalsIgnoreCase(abstractDatastore.getApiName())) {
			abstractDatastore = gson.fromJson(json,Ingredient.class);
		} else if (RECIPEINGREDIENT.equalsIgnoreCase(abstractDatastore
				.getApiName())) {
			abstractDatastore = gson.fromJson(json, RecipeIngredient.class);
		} else if (RECIPE.equalsIgnoreCase(abstractDatastore.getApiName())) {
			abstractDatastore = gson.fromJson(json, Recipe.class);
		}
		// Store the data
		if (basehttpservlet instanceof ApiServlet) {
			OfyService.store(abstractDatastore);
		} else if (basehttpservlet instanceof RetriveApiServlet) {
			RequestHandler requestHandler = (RequestHandler) abstractHandler;
			OfyService.read(requestHandler.startLimit, requestHandler.endLimit,abstractDatastore);
		} else if (basehttpservlet instanceof DeleteApiServelet) {
			// Delete the data
			OfyService.delete();
		}

	}
}
