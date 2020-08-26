package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Quiz extends Composite {

	private static QuizUiBinder uiBinder = GWT.create(QuizUiBinder.class);

	interface QuizUiBinder extends UiBinder<Widget, Quiz> {
	}

	public Quiz() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
