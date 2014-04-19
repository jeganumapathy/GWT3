package com.sample.g.server;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import com.sample.g.server.handler.RequestHandler;
import com.sample.g.server.handler.ResponseHandler;

public class SearchApiServelet extends BaseHttpServlet {

	/**
	 */
	private static final long serialVersionUID = 1L;

	public SearchApiServelet() {
		requestHandler = new RequestHandler(this);
		responseHandler = new ResponseHandler(this);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		if(isValidRequest){
			requestHandler.doProcessPost();
		}

	};

	@Override
	public void onPostComplete(Object result) throws IOException {
	}

	@Override
	public void onGetComplete() throws IOException {
	}

}
