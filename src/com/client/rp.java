package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;

public class rp extends Composite {

	private static rpUiBinder uiBinder = GWT.create(rpUiBinder.class);

	interface rpUiBinder extends UiBinder<Widget, rp> {
	}

	public rp() {
		initWidget(uiBinder.createAndBindUi(this));
	}@UiField
	MaterialLink t1;
	
	@UiField
	MaterialLink t3;
	
	@UiField
	MaterialPanel container;
	
	@UiHandler("t1")
	void onClick(ClickEvent e)
	{
		RootPanel.get("tt").clear();
		Card a1=new Card();
	
		RootPanel.get("tt").add(a1);
}
	@UiHandler("t3")
	void onClick1(ClickEvent e) {
		Play1 a1=new Play1();
		RootPanel.get("tt").clear();
		RootPanel.get("tt").add(a1);
		
}}