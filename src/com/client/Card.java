package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.Obean;
import com.shared.Studentmcq;
import com.shared.quizcheck;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;

public class Card extends Composite {
	GreetingServiceAsync a2 = GWT.create(GreetingService.class);

	private static CardUiBinder uiBinder = GWT.create(CardUiBinder.class);

	interface CardUiBinder extends UiBinder<Widget, Card> {
	}
	MaterialLabel ll1;
	MaterialRadioButton m1, m2, m3, m4;
	MaterialButton b2;
	MaterialPanel p;

	
	String s1;
	int counter = 0;
	int i;
	MaterialCard card;
	quizcheck qcc = new quizcheck();

	public Card() {
		initWidget(uiBinder.createAndBindUi(this));
		a2.tname(null, new AsyncCallback<Studentmcq[]>() {

			@Override
			public void onSuccess(Studentmcq[] result) {
				// TODO Auto-generated method stub

				MaterialButton b[] = new MaterialButton[result.length];
				int xx = 0;
				MaterialPanel p1 = new MaterialPanel();
				MaterialRow r1 = new MaterialRow();
				for (i = 1; i < result.length; i++) {
					MaterialColumn c1 = new MaterialColumn();
					card = new MaterialCard();
					card.setBackgroundColor(Color.BLUE_GREY_DARKEN_1);
					MaterialCardContent cont = new MaterialCardContent();
					cont.setTextColor(Color.WHITE);
					MaterialCardTitle t1 = new MaterialCardTitle();
					t1.setText(result[i].getTeachername());
					MaterialLabel l1 = new MaterialLabel("Subject:" + result[i].getSubname());
					MaterialLabel l2=new MaterialLabel(result[i].getTeacherid());
					b[xx] = new MaterialButton(Integer.toString(xx));
					b[xx].setWidth("20%");
					//b[xx] = new MaterialButton(Integer.toString(xx));
				//	cont.add(b[xx]);
					String msg = Integer.toString(xx);
				
					l1.setFontWeight(FontWeight.BOLDER);
					cont.add(t1);
					cont.add(l1);
					cont.add(l2);
					cont.add(b[xx]);
					String g=result[i].getTeacherid();
					//String g=(result[i].getTeacherid());
					b[xx].addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {
							//String g=(result[i].getTeacherid());
							//String g=Integer.toString(result[i].getTeacherid());
							Window.alert(g);
							a2.fetch(g, new AsyncCallback<Obean[]>() {
								
								@Override
								public void onSuccess(Obean[] result) {
									// TODO Auto-generated method stub
									RootPanel.get("tt").clear();
									i = 0;
									ll1 = new MaterialLabel(result[i].getQuestion());
									ll1.setFontSize("7.5em");
									ll1.getElement().getStyle().setColor("white");
								//	l1.getElement().getStyle().setFontFamily();
									
							
								m1 = new MaterialRadioButton("name", result[i].getAns1());
									
								
									m2 = new MaterialRadioButton("name", result[i].getAns2());
									m3 = new MaterialRadioButton("name", result[i].getAns3());
									m4 = new MaterialRadioButton("name", result[i].getAns4());
									
								
								
									b2 = new MaterialButton("NEXT");
									RootPanel.get("tt").add(ll1);
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
											ll1.setText(result[i].getQuestion());
											m1.setText(result[i].getAns1());
											m2.setText(result[i].getAns2());
											m3.setText(result[i].getAns3());
											m4.setText(result[i].getAns4());

										}

									});
									
								}
								
								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									
								}
							});
							
							
							qcc.setQc(msg);
							Window.alert(qcc.getQc());

						}
					});
					xx += 1;
					card.add(cont);
					c1.add(card);
					c1.setGrid("l4 m4 s12");
					r1.add(c1);
					p1.add(r1);
					RootPanel.get("tt").add(p1);

				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

}
