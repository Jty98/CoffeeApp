package com.javalec.dto;

public class Jty_Dto_Profile {
	
	 private String cname;
	    private String cid;
	    private String cpassword;
	    private String cphone;
	    private String cemail;
	    private String caddress;
	    private String cpayPassword;
	
	
    public Jty_Dto_Profile(String cname, String cid, String cpassword, String cphone, String cemail, String caddress, String cpayPassword) {
        this.cname = cname;
        this.cid = cid;
        this.cpassword = cpassword;
        this.cphone = cphone;
        this.cemail = cemail;
        this.caddress = caddress;
        this.cpayPassword = cpayPassword;
    }


	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}


	public String getCphone() {
		return cphone;
	}


	public void setCphone(String cphone) {
		this.cphone = cphone;
	}


	public String getCemail() {
		return cemail;
	}


	public void setCemail(String cemail) {
		this.cemail = cemail;
	}


	public String getCaddress() {
		return caddress;
	}


	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	public String getCpayPassword() {
		return cpayPassword;
	}


	public void setCpayPassword(String cpayPassword) {
		this.cpayPassword = cpayPassword;
	}
	
	
	
	
	
	

}
