package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);
	GreetingServiceAsync ab = GWT.create(GreetingService.class);
	
	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
/*History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				Myspace.getInstance().koifucntion();
			}
		});*/
	}
	@UiField
	MaterialTextBox t1;
	
	@UiField
	MaterialTextBox t2;
	
	@UiField
	MaterialButton b1;
	
	@UiField
	MaterialButton b2;
	
	
	
	public Login(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		b2.setText("firstName");
	}

	@UiHandler("b1")
	void onClick(ClickEvent e)
	{
		String s1=t1.getText();
		String s2=t2.getText();
		if(s1.isEmpty()||s2.isEmpty()) {
			MaterialToast.fireToast("Enter all details");
		}
		else {
		
		ab.Login(s1,s2,new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("yes")) {
					MaterialToast.fireToast("logged in....");
				RootPanel.get().clear();
					RootPanel.get().add(new rr());
					//History.newItem("aa");
					//Myspace.getInstance().koifucntion();
					
			}}

});
		}
		}
	@UiHandler("b2")
	void onClick1(ClickEvent e)
	{

		String s1=t1.getText();
		String s2=t2.getText();
		
		
		ab.Login1(s1,s2,new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("yes")) {
					
					RootPanel.get().clear();
					RootPanel.get().add(new rp());
					
					//History.newItem("bb");
					//Myspace.getInstance().koifucntion();
			}}

});
	}

}
