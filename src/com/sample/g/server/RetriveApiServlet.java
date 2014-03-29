package com.sample.g.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.g.server.handler.RequestHandler;
import com.sample.g.server.handler.ResponseHandler;
import com.sample.g.server.service.OfyService;

public class RetriveApiServlet extends BaseHttpServlet {

	private static final long serialVersionUID = 1L;

	public RetriveApiServlet() {
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
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		requestHandler.doProcessGet();

	}

	@Override
	public void onPostComplete() throws IOException {
		HttpServletResponse response = responseHandler.getResponse();
		response.setContentType("text/plain");
		response.getWriter().println("Deleted..");
	}

	@Override
	public void onGetComplete() throws IOException {
		HttpServletResponse resp = responseHandler.getResponse();
		resp.setContentType("text/plain");
		resp.getWriter().println(DATA + "=" + OfyService.read("", "", null));
	}

}
