package com.sample.g.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.g.server.handler.RequestHandler;
import com.sample.g.server.handler.ResponseHandler;

public class DeleteApiServelet extends BaseHttpServlet {

	private static final long serialVersionUID = 1L;

	public DeleteApiServelet() {
		requestHandler = new RequestHandler(this);
		responseHandler = new ResponseHandler(this);
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
	public void onPostComplete(Object result) throws IOException {
		HttpServletResponse response = responseHandler.getResponse();
		response.setContentType("text/plain");
		response.getWriter().println("Deleted..");
	}

	@Override
	public void onGetComplete() throws IOException {
	}

}
