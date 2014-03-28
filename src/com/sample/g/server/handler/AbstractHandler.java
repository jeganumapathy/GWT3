package com.sample.g.server.handler;

import java.io.IOException;

import com.sample.g.data.Constants;

public abstract class AbstractHandler implements Constants{

	public abstract void doProcessPost() throws IOException;

	public abstract void doProcessGet();

	public void processError(String msg) {
	}

}
