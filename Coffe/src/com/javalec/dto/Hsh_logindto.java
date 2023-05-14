package com.javalec.dto;

public class Hsh_logindto {
	String cid;
	String cpassword;
	public Hsh_logindto(String cid, String cpassword) {
		super();
		this.cid = cid;
		this.cpassword = cpassword;
	}
	
	public Hsh_logindto() {
		// TODO Auto-generated constructor stub
	}

	public String getcid() {
		return cid;
	}

	public void setcid(String cid) {
		this.cid = cid;
	}

	public String getcpassword() {
		return cpassword;
	}

	public void setcpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
}

