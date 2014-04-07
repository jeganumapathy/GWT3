package com.sample.g.server.service;

import static com.sample.g.server.service.OfyService.ofy;

import java.util.List;

import com.sample.g.data.AbstractDatastore;
import com.sample.g.data.Constants;
import com.sample.g.data.FoodCatagories;
import com.sample.g.data.Ingredient;
import com.sample.g.data.Recipe;
import com.sample.g.data.RecipeIngredient;

/**
 * Should update data here
 * @author jacky
 */
public class StoreFactory implements Constants {
	private static StoreFactory instance;

	public static final int STORE_LIMIT = 100;

	/**
	 * Retrieve a instance for store factory
	 * @return
	 */
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
		}else if(INGREDIENT.equalsIgnoreCase(dataStore.getApiName())){
			Ingredient obj = (Ingredient) dataStore;
			try {
				List<Ingredient> obj2 = ofy().load()
						.type(Ingredient.class).limit(STORE_LIMIT).list();
				for (Ingredient i : obj2) {
					if (obj.name.equalsIgnoreCase(i.name))
						return false;
				}
			} catch (Exception e) {
				return true;
			}
		}else if(RECIPEINGREDIENT.equalsIgnoreCase(dataStore.getApiName())){
			RecipeIngredient obj = (RecipeIngredient) dataStore;
		}
		return true;
	}

	public static void getStoreById(long id) {
	}

}
