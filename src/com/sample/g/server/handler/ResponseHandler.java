package com.sample.g.server.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.sample.g.server.BaseHttpServlet;

public class ResponseHandler extends AbstractHandler {

	public ResponseHandler(BaseHttpServlet basehttpservlet) {
	}

	private HttpServletResponse response;

	@Override
	public void doProcessPost() {
		try {
			response.setContentType("text/plain");
			response.getWriter().println("Success..");
		} catch (IOException e) {
			processError(e.getMessage());
		}
	}

	@Override
	public void processError(String msg) {
		super.processError(msg);
		System.out.println(msg);
		// email the dev about the error
	}

	@Override
	public void doProcessGet() {
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
