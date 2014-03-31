package com.sample.g.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.g.server.handler.RequestHandler;
import com.sample.g.server.handler.ResponseHandler;
import com.sample.g.server.service.OfyService;

public class ApiServlet extends BaseHttpServlet {

	/**
	 */
	private static final long serialVersionUID = 1L;

	public ApiServlet() {
		requestHandler = new RequestHandler(this);
		responseHandler = new ResponseHandler(this);
	}

	@Override
	public void onPostComplete() throws IOException {
		responseHandler.doProcessPost();
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
