package com.sample.g.server.service;

import com.google.gson.Gson;
import com.sample.g.data.AbstractDatastore;
import com.sample.g.data.Constants;
import com.sample.g.data.FoodCatagories;
import com.sample.g.data.Ingredient;
import com.sample.g.data.Recipe;
import com.sample.g.data.RecipeIngredient;
import com.sample.g.server.BaseHttpServlet;
import com.sample.g.server.handler.AbstractHandler;

public class JsonService implements Constants {
	public Gson gson = null;
	BaseHttpServlet basehttpservlet;
	AbstractHandler abstractHandler;
	private String json;
	public AbstractDatastore abstractDatastore;

	public JsonService(BaseHttpServlet basehttpservlet,
			AbstractHandler abstractHandler) {
		this.basehttpservlet = basehttpservlet;
		this.abstractHandler = abstractHandler;
		gson = new Gson();
	}

	public String getJson() {
		return json;
	}

	public Object onHandle(String json) {
		this.json = json;
		abstractDatastore = gson.fromJson(json, AbstractDatastore.class);
		if (FOODCATAGORIES.equalsIgnoreCase(abstractDatastore.getApiName())) {
			abstractDatastore = gson.fromJson(json, FoodCatagories.class);
		} else if (INGREDIENT.equalsIgnoreCase(abstractDatastore.getApiName())) {
			abstractDatastore = gson.fromJson(json, Ingredient.class);
		} else if (RECIPEINGREDIENT.equalsIgnoreCase(abstractDatastore
				.getApiName())) {
			abstractDatastore = gson.fromJson(json, RecipeIngredient.class);
		} else if (RECIPE.equalsIgnoreCase(abstractDatastore.getApiName())) {
			abstractDatastore = gson.fromJson(json, Recipe.class);
		}
		IServiceDelegate businessDelegate = new IServiceDelegate();
		businessDelegate.setJsonService(this);
		businessDelegate.setServletTpe(basehttpservlet);
		return businessDelegate.doTaskService();
	}
}
