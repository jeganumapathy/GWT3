package com.sample.g.data;

import static com.sample.g.data.OfyService.ofy;

import java.util.List;

public class StoreFactory implements Constants {
	private static StoreFactory instance;

	public static final int STORE_LIMIT = 100;

	public static StoreFactory getInstance() {
		if (instance == null) {
			instance = new StoreFactory();
		}
		return instance;
	}

	/**
	 * synchronous Store a Data object into the GOOGLE data store.
	 * 
	 * @param dataStore
	 */
	public static void store(AbstractDatastore dataStore) {
		if (dataStore instanceof FoodCatagories) {
			FoodCatagories obj = (FoodCatagories) dataStore;
			if (shouldSave(dataStore))
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

	public static boolean shouldSave(AbstractDatastore dataStore) {
		if (FOODCATAGORIES.equalsIgnoreCase(dataStore.getApiName())) {
			FoodCatagories obj = (FoodCatagories) dataStore;
			try {
				List<FoodCatagories> obj2 = ofy().load()
						.type(FoodCatagories.class).limit(STORE_LIMIT).list();
				for (FoodCatagories foodCatagories : obj2) {
					if (obj.name.equalsIgnoreCase(foodCatagories.name))
						return false;
				}
			} catch (Exception e) {
				return true;
			}
		}
		return true;
	}

	public static void getStoreById(long id) {
	}

}
