package com.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Myspace {
	static Myspace m=null;
	
	
	Login a2=null;
	Ff a3=null;
	jkl a4=null;
	Quiz a5=null;
	rp a6=null;
	rr a7=null;
	Play a8=null;
	Play1 a9=null;
	
	private Myspace() {
		
	}
	static Myspace getInstance()
	{
		if(m==null) {
			m=new Myspace();
		}
		return m;
		
	}
	public void koifucntion()
	{
		if (History.getToken().equals("aa"))
		{
			RootPanel.get().clear();
			RootPanel.get().add(getrr());
		
			
		}
		else if (History.getToken().equals("ab"))
		{
			RootPanel.get().clear();
			RootPanel.get().add(getLogin());
		
			
		}
		
		else if (History.getToken().equals("bb"))
		{
			RootPanel.get().clear();
			RootPanel.get().add(getrp());
		
			
		}
		else if (History.getToken().equals("cc"))
		{
			RootPanel.get().clear();
			RootPanel.get().add(getjkl());
		
			
		}
	
	}
jkl getjkl() {
		// TODO Auto-generated method stub
	if(a4==null)
	{
		a4=new jkl();
	}
		return a4;
	}
rp getrp() {
		// TODO Auto-generated method stub
	if(a6==null)
	{
		a6=new rp();
	}
		return a6;
	}
	rr getrr() {
		// TODO Auto-generated method stub
		if(a7==null)
		{
			a7=new rr();
		}
		return a7;
	}
Login getLogin() {
		// TODO Auto-generated method stub
	if(a2==null)
	{
		a2=new Login();
	}
		return a2;
	}
	

}
