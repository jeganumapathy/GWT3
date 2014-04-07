package com.sample.g.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.g.data.FoodCatagories;
import com.sample.g.data.JsonAnalyser;
import com.sample.g.data.Recipe;
import com.sample.g.data.RecipeIngredient;
import com.sample.g.server.handler.RequestHandler;
import com.sample.g.server.handler.ResponseHandler;

public class ApiServlet extends BaseHttpServlet {

	/**
	 */
	private static final long serialVersionUID = 1L;

	public ApiServlet() {
		requestHandler = new RequestHandler(this);
		responseHandler = new ResponseHandler(this);
	}

	@Override
	public void onPostComplete(Object result) throws IOException {
		responseHandler.doProcessPost();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		Recipe recipe = new Recipe();
		recipe.name = "oatmeal";
		recipe.setApiName(RECIPE);
		recipe.id = 1L;
		recipe.food_catagories = new FoodCatagories();
		recipe.food_catagories.name = "Vege";
		recipe.food_catagories.id = 1L;
		// recipe.ingredient = new RecipeIngredient();
		// recipe.ingredient.comments = "super ingredient";
		resp.setContentType("text/plain");
		resp.getWriter().println(JsonAnalyser.printJSON(recipe));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		if (isValidRequest) {
			requestHandler.doProcessPost();
		}
	}

	@Override
	public void onGetComplete() throws IOException {

	}

}
