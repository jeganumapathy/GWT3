package com.sample.g.server.handler;

import com.sample.g.data.Constants;

public abstract class AbstractHandler implements Constants{

	public abstract void doProcessPost();

	public abstract void doProcessGet();

	public void processError(String msg) {
	}

}
