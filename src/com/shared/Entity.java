package com.shared;

import java.io.Serializable;

public class Entity implements Serializable {


	private static final long serialVersionUID = 1L;

	public String que;
	public String ans1;
	public String ans2;
	public String ans3;
	public String ans4;
	public String cans;
	public String teachid;

	public String getTeachid() {
		return teachid;
	}

	public void setTeachid(String teachid) {
		this.teachid = teachid;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}

	public String getCans() {
		return cans;
	}

	public void setCans(String cans) {
		this.cans = cans;
	}
}
