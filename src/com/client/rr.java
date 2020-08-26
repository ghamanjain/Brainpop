package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;

public class rr extends Composite {

	private static rrUiBinder uiBinder = GWT.create(rrUiBinder.class);

	interface rrUiBinder extends UiBinder<Widget, rr> {
	}

	public rr() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField
	MaterialLink t1;
	
	@UiField
	MaterialLink t2;
	
	@UiField
	MaterialPanel con;

	public rr(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		t1.setText("firstName");
	}

	@UiHandler("t1")
	void onClick(ClickEvent e)
	{
		
		jkl a1=new jkl();
		RootPanel.get("tt1").clear();
		RootPanel.get("tt1").add(a1);
	//	History.newItem("cc");
	//	Myspace.getInstance().koifucntion();
	}
	@UiHandler("t2")
	void onClick1(ClickEvent e)
	{
		
		Ff a1=new Ff();
		RootPanel.get("tt1").clear();
		RootPanel.get("tt1").add(a1);
		
	}
	}
