package com.sample.g.server.handler;

import javax.servlet.http.HttpServletRequest;

public class RequestHandler extends AbstractHandler {

	private HttpServletRequest request;
	private JsonHandler jsonHandler;
	
	
	public RequestHandler() {
		jsonHandler = new JsonHandler();
	}

	@Override
	public void doProcessPost() {
		String requestJson = request.getParameter(DATA);
		if(requestJson != null && requestJson.length() > 2){
			jsonHandler.onHandle(requestJson);
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
