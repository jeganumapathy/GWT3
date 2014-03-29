package com.sample.g.server.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.sample.g.server.ActionListener;
import com.sample.g.server.BaseHttpServlet;
import com.sample.g.server.service.JsonService;

public class RequestHandler extends AbstractHandler {

	private HttpServletRequest request;
	private JsonService jsonHandler;
	private ActionListener actionListener;
	public String startLimit;
	public String endLimit;

	public RequestHandler(BaseHttpServlet basehttpservlet) {
		jsonHandler = new JsonService(basehttpservlet, this);
	}

	public void setOnActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	@Override
	public void doProcessPost() throws IOException {
		String requestJson = request.getParameter(DATA);
		startLimit = request.getParameter(START_LIMIT);
		endLimit = request.getParameter(END_LIMIT);
		if (requestJson != null && requestJson.length() > 2) {
			jsonHandler.onHandle(requestJson);
			if (actionListener != null) {
				actionListener.onPostComplete();
			}
		}
	}

	@Override
	public void doProcessGet() {
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
