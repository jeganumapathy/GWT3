package com.sample.g.data;

import static com.sample.g.data.OfyService.ofy;

public class StoreFactory {
	private static StoreFactory instance;

	public static StoreFactory getInstance() {
		if (instance == null) {
			instance = new StoreFactory();
		}
		return instance;
	}

	/**
	 * synchronous Store a Data object into the GOOGLE data store.
	 * @param dataStore
	 */
	public static void store(AbstractDatastore dataStore) {
		if (dataStore instanceof FoodCatagories) {
			FoodCatagories obj = (FoodCatagories) dataStore;
			ofy().save().entity(obj).now();
		} else if (dataStore instanceof Ingredient) {
			Ingredient obj = (Ingredient) dataStore;
			ofy().save().entity(obj).now();
		} else if (dataStore instanceof Recipe) {
			Recipe obj = (Recipe) dataStore;
			ofy().save().entity(obj).now();
		} else if (dataStore instanceof RecipeIngredient) {
			RecipeIngredient obj = (RecipeIngredient) dataStore;
			ofy().save().entity(obj).now();
		}
	}

	public static void getStoreById(long id) {
	}

}
