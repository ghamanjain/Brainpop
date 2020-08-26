package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialLink;

public class Homee extends Composite {

	private static HomeeUiBinder uiBinder = GWT.create(HomeeUiBinder.class);

	interface HomeeUiBinder extends UiBinder<Widget, Homee> {
	}

	public Homee() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField
	MaterialLink t1;


	public Homee(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	@UiHandler("t1")
	void onClick(ClickEvent e)
	{	RootPanel.get().clear();
		RootPanel.get().add(new Login());
	
	}
	@UiHandler("t2")
		void onClick1(ClickEvent e) {
		
		RootPanel.get().clear();
		RootPanel.get().add(new Reg());
}}
