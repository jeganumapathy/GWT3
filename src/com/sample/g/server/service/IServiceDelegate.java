package com.sample.g.server.service;

import com.sample.g.server.BaseHttpServlet;

public class IServiceDelegate {

	private IServiceLookup lookUpService = new IServiceLookup();
	private IService businessService;
	private BaseHttpServlet servletType;
	private JsonService jsonService;
	public String result;

	public void setServletTpe(BaseHttpServlet servletType) {
		this.servletType = servletType;
	}

	public void setJsonService(JsonService jsonService) {
		this.jsonService = jsonService;
	}

	public Object doTaskService() {
		lookUpService.setJsonService(jsonService);
		businessService = lookUpService.getBusinessService(servletType);
		if (businessService != null)
			return businessService.doProcessing();
		return null;

	}

}
