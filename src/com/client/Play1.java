package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.Obean1;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialListBox;
import gwt.material.design.client.ui.MaterialPanel;

public class Play1 extends Composite {

	private static Play1UiBinder uiBinder = GWT.create(Play1UiBinder.class);
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	interface Play1UiBinder extends UiBinder<Widget, Play1> {
	}
	MaterialLabel l1, l2, l3, l4, l5;
	MaterialListBox m1, m2, m3, m4;
	MaterialButton b2;
	MaterialPanel p;
	
	int i;
	String s1;
	int counter = 0;

	public Play1() {
		initWidget(uiBinder.createAndBindUi(this));
		a1.fetch1("AAA", new AsyncCallback<Obean1[]>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Obean1[] result) {
				// TODO Auto-generated method stub
				/*RootPanel.get("t1").clear();
				i = 0;
				l1 = new MaterialLabel(result[i].getQuestion());
				l1.setFontSize("3.5em");
				
				RootPanel.get("t1").add(l1);
				
				/*l1.setText("ddddd");
				l2.setText("gggggggggggggggggggggggggg");
				l1.setFontSize("5.5em");
				l2.setFontSize("5.5em");
				
				RootPanel.get("t1").add(l1);
				RootPanel.get("t1").add(l2);
				*/

				RootPanel.get("tt").clear();
				i = 0;
				

				l1=new MaterialLabel("Question:"+result[i].getQuestion());
				l2=new MaterialLabel("Option A:" + result[i].getAns1());
				l3=new MaterialLabel("Option B:" + result[i].getAns2());
				l4=new MaterialLabel("Option C:" + result[i].getAns3());
				l5=new MaterialLabel("Option D:" + result[i].getAns4());
				l1.setFontSize("3.1em");
				l2.setFontSize("2.5em");
				l3.setFontSize("2.5em");
				l4.setFontSize("2.5em");
				l5.setFontSize("2.5em");
				l1.getElement().getStyle().setColor("white");
				 
				m1=new MaterialListBox();
				m1.clear();
				m1.addItem("SELECT OPTION");
				m1.addItem("A");
				m1.addItem("B");
				m1.addItem("C");
				m1.addItem("D");
				
				m2=new MaterialListBox();
				m2.clear();
				m2.addItem("SELECT OPTION");
				m2.addItem("A");
				m2.addItem("B");
				m2.addItem("C");
				m2.addItem("D");

				m3=new MaterialListBox();
				m3.clear();
				m3.addItem("SELECT OPTION");
				m3.addItem("A");
				m3.addItem("B");
				m3.addItem("C");
				m3.addItem("D");

				m4=new MaterialListBox();
				m4.clear();
				m4.addItem("SELECT OPTION");
				m4.addItem("A");
				m4.addItem("B");
				m4.addItem("C");
				m4.addItem("D");
				b2 = new MaterialButton("NEXT");
				RootPanel.get("tt").add(l1);
				RootPanel.get("tt").add(l2);
				RootPanel.get("tt").add(l3);
				RootPanel.get("tt").add(l4);
				RootPanel.get("tt").add(l5);
				RootPanel.get("tt").add(m1);
				RootPanel.get("tt").add(m2);
				RootPanel.get("tt").add(m3);
				RootPanel.get("tt").add(m4);
				RootPanel.get("tt").add(b2);
				b2.addClickHandler(new ClickHandler() {
					
					

					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						String s1=m1.getSelectedItemText();
						String s2=m2.getSelectedItemText();	
						String s3=m3.getSelectedItemText();
						String s4=m4.getSelectedItemText();
						
						String s5=s1+s2+s3+s4;
						
						if (s5.equals(result[i].getCans())) {
							counter += 1;
						}
						i++;
						if (i == result.length) {
							RootPanel.get("tt").clear();
							RootPanel.get("tt").clear();
							if (counter >= 3)

								Window.alert("Your score is " + counter + " out of " + result.length);
							else
								Window.alert("Fail");
						}
						l1.setText("Question:" + result[i].getQuestion());
						l2.setText("Option A:" + result[i].getAns1());
						l3.setText("Option B:" + result[i].getAns2());
						l4.setText("Option c:" + result[i].getAns3());
						l5.setText("Option D:" + result[i].getAns4());
						
						l1.setFontSize("3.1em");
						 
						
						m1.clear();
						m1.addItem("SELECT OPTION");
						m1.addItem("A");
						m1.addItem("B");
						m1.addItem("C");
						m1.addItem("D");
						
						
						m2.clear();
						m2.addItem("SELECT OPTION");
						m2.addItem("A");
						m2.addItem("B");
						m2.addItem("C");
						m2.addItem("D");

						
						m3.clear();
						m3.addItem("SELECT OPTION");
						m3.addItem("A");
						m3.addItem("B");
						m3.addItem("C");
						m3.addItem("D");

						
						m4.clear();
						m4.addItem("SELECT OPTION");
						m4.addItem("A");
						m4.addItem("B");
						m4.addItem("C");
						m4.addItem("D");
					}
			});
	
	}	
	});}}
