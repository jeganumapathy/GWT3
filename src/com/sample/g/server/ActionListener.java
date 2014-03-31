package com.sample.g.server;

import java.io.IOException;

public interface ActionListener {

	public void onPostComplete() throws IOException;
	
	public void onGetComplete() throws IOException;
	
}
