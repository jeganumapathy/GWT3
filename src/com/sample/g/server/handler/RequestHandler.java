package com.sample.g.server.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.sample.g.server.ActionListener;
import com.sample.g.server.BaseHttpServlet;

public class RequestHandler extends AbstractHandler {

	private HttpServletRequest request;
	private JsonHandler jsonHandler;
	private ActionListener actionListener;

	public RequestHandler(BaseHttpServlet basehttpservlet) {
		jsonHandler = new JsonHandler(basehttpservlet, this);
	}

	public void setOnActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	@Override
	public void doProcessPost() throws IOException {
		String requestJson = request.getParameter(DATA);
		String startLimit = request.getParameter(START_LIMIT);
		String endLimit = request.getParameter(END_LIMIT);
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
