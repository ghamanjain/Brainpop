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
import com.shared.Obean;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRadioButton;

public class Play extends Composite {

	private static PlayUiBinder uiBinder = GWT.create(PlayUiBinder.class);

	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	interface PlayUiBinder extends UiBinder<Widget, Play> {
	}

	// GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	MaterialLabel l1;
	MaterialRadioButton m1, m2, m3, m4;
	MaterialButton b2;
	MaterialPanel p;

	int i;
	String s1;
	int counter = 0;

	public Play() {
		initWidget(uiBinder.createAndBindUi(this));
		a1.fetch("AAA", new AsyncCallback<Obean[]>() {
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Obean[] result) {
				// TODO Auto-generated method stub
			
				RootPanel.get("tt").clear();
				i = 0;
				l1 = new MaterialLabel(result[i].getQuestion());
				l1.setFontSize("7.5em");
				l1.getElement().getStyle().setColor("white");
			//	l1.getElement().getStyle().setFontFamily();
				
		
			m1 = new MaterialRadioButton("name", result[i].getAns1());
				
			
				m2 = new MaterialRadioButton("name", result[i].getAns2());
				m3 = new MaterialRadioButton("name", result[i].getAns3());
				m4 = new MaterialRadioButton("name", result[i].getAns4());
				
			
			
				b2 = new MaterialButton("NEXT");
				RootPanel.get("tt").add(l1);
				RootPanel.get("tt").add(m1);
				RootPanel.get("tt").add(m2);
				RootPanel.get("tt").add(m3);
				RootPanel.get("tt").add(m4);
				RootPanel.get("tt").add(b2);
				b2.addClickHandler(new ClickHandler() {

					@SuppressWarnings("deprecation")
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						if (m1.isChecked()) {
							s1 = m1.getText();
							m1.setChecked(false);
						}
						if (m2.isChecked()) {
							s1 = m2.getText();
							m2.setChecked(false);
						}
						if (m3.isChecked()) {
							s1 = m3.getText();
							m3.setChecked(false);
						}
						if (m4.isChecked()) {
							s1 = m4.getText();
							m4.setChecked(false);
						}
						if (s1.equals(result[i].getCans())) {
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
						l1.setText(result[i].getQuestion());
						m1.setText(result[i].getAns1());
						m2.setText(result[i].getAns2());
						m3.setText(result[i].getAns3());
						m4.setText(result[i].getAns4());

					}

				});
			}

		});
	}
	

}
