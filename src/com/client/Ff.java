package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.shared.Entity;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class Ff extends Composite {

	private static FfUiBinder uiBinder = GWT.create(FfUiBinder.class);
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	interface FfUiBinder extends UiBinder<Widget, Ff> {
	}

	public Ff() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField
	MaterialLabel l1;
	@UiField 
	MaterialTextBox t1;
	@UiField 
	MaterialTextBox t2;
	@UiField 
	MaterialTextBox t3;
	@UiField 
	MaterialTextBox t4;
	@UiField 
	MaterialTextBox t5;
	@UiField 
	MaterialTextBox t6;
	@UiField
	MaterialButton b1;
	
	@UiHandler("b1")
	void onClick(ClickEvent e) {
		String s1 = t1.getText();
		String s2 = t2.getText();
		String s3 = t3.getText();
		String s4 = t4.getText();
		String s5 = t5.getText();
		String s6 = t6.getText();
		
		

		Entity eee = new Entity();

		eee.setQue(s1);
		eee.setAns1(s2);
		eee.setAns2(s3);
		eee.setAns3(s4);
		eee.setAns4(s5);
		eee.setCans(s6);
		
		a1.qq(eee, new AsyncCallback<Entity>() {
			@Override
			public void onSuccess(Entity result) {
				MaterialToast.fireToast("Question Inserted", "rounded");
			}

			@Override
			public void onFailure(Throwable caught) {
				MaterialToast.fireToast("Internal Error", "rounded");
			}
		});
	}
			
			public void setText(String text) {
				b1.setText(text);
			}

			public String getText() {
				return b1.getText();
}}
