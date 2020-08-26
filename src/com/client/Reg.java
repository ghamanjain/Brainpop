package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.shared.user;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class Reg extends Composite {

	private static RegUiBinder uiBinder = GWT.create(RegUiBinder.class);

	GreetingServiceAsync aa = GWT.create(GreetingService.class);

	interface RegUiBinder extends UiBinder<Widget, Reg> {
	}

	public Reg() {
		initWidget(uiBinder.createAndBindUi(this));

	}

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
	MaterialButton b1;
	
	

	public Reg(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		b1.setText("firstName");
	}

	@UiHandler("b1")
	void onClick(ClickEvent e) {
		String s1 = t1.getText();
		String s2 = t2.getText();
		String s3 = t3.getText();
		String s4 = t4.getText();
		String s5 = t5.getText();
		Window.alert("aaaaaaaa");

		user u = new user();
		
		
		u.setFirstname(s1);
		u.setLastname(s2);
		u.setEmail(s3);
		u.setPassword(s4);
		u.setConfirmpassword(s5);

		aa.Brainpopp(u, new AsyncCallback<user>() {

			@Override
			public void onSuccess(user result) {
				// TODO Auto-generated method stub
				Window.alert("on success");

			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("on failure");
				// TODO Auto-generated method stub

			}
		});

	}

	public void setText(String text) {
		b1.setText(text);
	}

	public String getText() {
		return b1.getText();
	}

}
