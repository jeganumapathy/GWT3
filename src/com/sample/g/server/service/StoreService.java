package com.sample.g.server.service;

public class StoreService implements IService {

	private JsonService jsonService;

	public StoreService(JsonService jsonService) {
		this.jsonService = jsonService;
	}

	@Override
	public void doProcessing() {
		StoreFactory.store(jsonService.abstractDatastore);
	}

	@Override
	public void checkService() {
	}
}
