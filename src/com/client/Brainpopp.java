package com.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public class Brainpopp implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		//RootPanel.get().clear();
		//RootPanel.get().add(new Login());
		//History.newItem("ab");
		//Myspace.getInstance().koifucntion();
		RootPanel.get().clear();
		
		RootPanel.get().add(new Homee());
	}

}
