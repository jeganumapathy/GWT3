package com.sample.g.server.service;

import java.util.List;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.sample.g.data.AbstractDatastore;
import com.sample.g.data.FoodCatagories;
import com.sample.g.data.Ingredient;
import com.sample.g.data.JsonAnalyser;
import com.sample.g.data.Recipe;
import com.sample.g.data.RecipeIngredient;

/**
 * Should update here data
 * 
 * @author jacky
 */
public class OfyService {

	private static final int QUERY_LIMIT = 10;
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
			AbstractDatastore datastore) {
		List<FoodCatagories> c = ofy().load().type(FoodCatagories.class)
				.limit(QUERY_LIMIT).list();
		StringBuilder nBuilder = new StringBuilder();
		for (FoodCatagories foodCatagories : c) {
			nBuilder.append(JsonAnalyser.printJSON(foodCatagories));
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
