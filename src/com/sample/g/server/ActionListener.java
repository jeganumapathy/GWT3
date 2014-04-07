package com.sample.g.server;

import java.io.IOException;

public interface ActionListener {

	public void onPostComplete(Object result) throws IOException;
	
	public void onGetComplete() throws IOException;
	
}
