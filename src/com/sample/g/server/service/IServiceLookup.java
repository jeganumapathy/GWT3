package com.sample.g.server.service;

import com.sample.g.data.Constants;
import com.sample.g.server.ApiServlet;
import com.sample.g.server.BaseHttpServlet;
import com.sample.g.server.DeleteApiServelet;

public class IServiceLookup implements Constants {

	private JsonService jsonService;
	
	public void setJsonService(JsonService jsonService) {
		this.jsonService =  jsonService;
	}

	public IService getBusinessService(BaseHttpServlet basehttpservlet) {
		if (basehttpservlet instanceof ApiServlet) {
			return new StoreService(jsonService);
		} else if (basehttpservlet instanceof DeleteApiServelet) {
			return new DeleteService(jsonService);
		} else {
			return new RetriveService(jsonService);
		}
	}
}
