package com.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.shared.Entity;
import com.shared.Obean;
import com.shared.Obean1;
import com.shared.Studentmcq;
import com.shared.user;

public interface GreetingServiceAsync {
	
	void Brainpopp(user u, AsyncCallback<user> callback)
		      throws IllegalArgumentException;
	void Login(String s1, String s2, AsyncCallback<String> callback) throws IllegalArgumentException;

	void Login1(String s1, String s2, AsyncCallback<String> callback) throws IllegalArgumentException;

	void qb(Entity eee, AsyncCallback<Entity> callback) throws IllegalArgumentException;

	void qq(Entity eee, AsyncCallback<Entity> callback) throws IllegalArgumentException;
	
	void fetch(String input, AsyncCallback<Obean[]> asyncCallback) throws IllegalArgumentException;
	
	void fetch1(String input, AsyncCallback<Obean1[]> asyncCallback) throws IllegalArgumentException;
	void qui(Studentmcq a, AsyncCallback<String> callback)throws IllegalArgumentException;
	void tname(String s, AsyncCallback<Studentmcq[]> callback);
	
}
