package com.sample.g.server.service;

import java.util.List;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.sample.g.data.AbstractDatastore;
import com.sample.g.data.Constants;
import com.sample.g.data.FoodCatagories;
import com.sample.g.data.Ingredient;
import com.sample.g.data.JsonAnalyser;
import com.sample.g.data.Recipe;
import com.sample.g.data.RecipeIngredient;

public class OfyService implements Constants {

	static {
		factory().register(FoodCatagories.class);
		factory().register(Ingredient.class);
		factory().register(Recipe.class);
		factory().register(RecipeIngredient.class);
	}

	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}

	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}

	public static void store(AbstractDatastore dataStore) {
		StoreFactory.store(dataStore);
	}

	public static String read(String startLimit, String endLimit,
			AbstractDatastore abstractDatastore) {
		int endLimitInt = Integer.valueOf(endLimit);
		int startLimitInt = Integer.valueOf(endLimit);
		if (startLimitInt != -1 && startLimitInt < endLimitInt) {
			return "error should have a limit";
		}
		return readData(abstractDatastore, endLimitInt);
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

	public static void delete() {
		List<FoodCatagories> c = ofy().load().type(FoodCatagories.class).list();
		for (FoodCatagories fc : c) {
			ofy().delete().type(FoodCatagories.class).id(fc.getId()).now();
		}
	}
}
