package com.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.shared.Entity;
import com.shared.Obean;
import com.shared.Obean1;
import com.shared.Studentmcq;
import com.shared.user;

@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	user Brainpopp(user u) throws IllegalArgumentException;
	public String Login(String s1, String s2) throws IllegalArgumentException;

	public String Login1(String s1, String s2) throws IllegalArgumentException;

	Entity qb(Entity eee) throws IllegalArgumentException;

	Entity qq(Entity eee) throws IllegalArgumentException;

	Obean[] fetch(String name) throws IllegalArgumentException;
	
	Obean1[] fetch1(String name) throws IllegalArgumentException;
	public String qui(Studentmcq a)throws IllegalArgumentException;
	
	Studentmcq[] tname(String s)throws IllegalArgumentException;
	
	
	
	
	
}
