package com.sample.g.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.g.data.Constants;
import com.sample.g.server.handler.RequestHandler;
import com.sample.g.server.handler.ResponseHandler;

public abstract class BaseHttpServlet extends HttpServlet implements Constants ,ActionListener{

	private static final long serialVersionUID = -2392341116640931531L;
	protected boolean isValidRequest;
	public RequestHandler requestHandler;
	public ResponseHandler responseHandler;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getParameterMap().containsKey(DATA)) {
			isValidRequest = true;
			requestHandler.setRequest(req);
			requestHandler.setOnActionListener(this);
			responseHandler.setResponse(resp);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, CHECK_POST_JSON);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		requestHandler.setRequest(req);
		requestHandler.setOnActionListener(this);
		responseHandler.setResponse(resp);
	}

}
