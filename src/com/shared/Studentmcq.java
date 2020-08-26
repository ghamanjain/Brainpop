package com.shared;

import java.io.Serializable;

public class Studentmcq implements Serializable {

	
	private static final long serialVersionUID = 1L;
	 
	String teacherid;
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	String teachername;
	String subname;
	
}
