package com.sample.g.data;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class AbstractDatastore {
	private String apiName;

	public AbstractDatastore() {
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

}
