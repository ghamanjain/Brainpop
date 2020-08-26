package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.Entity;
import com.shared.Studentmcq;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class jkl extends Composite {

	private static jklUiBinder uiBinder = GWT.create(jklUiBinder.class);
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	interface jklUiBinder extends UiBinder<Widget, jkl> {
	}

	public jkl() {
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
	MaterialTextBox t7;
	@UiField
	MaterialTextBox t8;
	@UiField
	MaterialTextBox t9;
	
	@UiField
	MaterialButton b1;
	@UiField
	MaterialButton b2;

	@UiHandler("b1")
	void onClick(ClickEvent e) {
		String s1 = t1.getText();
		String s2 = t2.getText();
		String s3 = t3.getText();
		String s4 = t4.getText();
		String s5 = t5.getText();
		String s6 = t6.getText();
		String s7=	t9.getText();

		Entity eee = new Entity();

		eee.setQue(s1);
		eee.setAns1(s2);
		eee.setAns2(s3);
		eee.setAns3(s4);
		eee.setAns4(s5);
		eee.setCans(s6);
		eee.setTeachid(s7);

		a1.qb(eee, new AsyncCallback<Entity>() {
			@Override
			public void onSuccess(Entity result) {
				MaterialToast.fireToast("Question Inserted", "rounded");
				t1.clear();
				t9.setEnabled(false);
				t2.clear();
				t3.clear();
				t4.clear();
				t5.clear();
				t6.clear();
			}

			@Override
			public void onFailure(Throwable caught) {
				MaterialToast.fireToast("Internal Error", "rounded");
			}
		});
	}
	

	@UiHandler("b2")
	void onClick1(ClickEvent e) {
	   Window.alert("btn");
	   Studentmcq a=new Studentmcq();
	    
		String s1=t7.getText();
		String s2=t8.getText();
		String s3=t9.getText();
		a.setTeacherid(s3);
		a.setTeachername(s1);
		a.setSubname(s2);
		
    a1.qui(a, new AsyncCallback<String>() {
		
		@Override
		public void onSuccess(String result) {
			// TODO Auto-generated method stub
			MaterialToast.fireToast("Success");
			t7.setEnabled(false);
			t8.setEnabled(false);
			b2.setEnabled(false);
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
	});


}
}