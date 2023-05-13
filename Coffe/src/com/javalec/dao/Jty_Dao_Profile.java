package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.javalec.dto.Jty_Dto_Profile;
import com.javalec.util.ShareVar;

public class Jty_Dao_Profile {
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String cid;
	String cname;
	String cpassword;
	String cphone;
	String cemail;
	String caddress;
	String cpayPassword;
	
	
	public Jty_Dao_Profile() {
		// TODO Auto-generated constructor stub
	}


	public Jty_Dao_Profile(String cid, String cname, String cpassword, String cphone, String cemail, String caddress,
			String cpayPassword) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cpassword = cpassword;
		this.cphone = cphone;
		this.cemail = cemail;
		this.caddress = caddress;
		this.cpayPassword = cpayPassword;
	}
	
	
	public Jty_Dao_Profile(String cid) {
		super();
		this.cid = cid;
	}


	public Jty_Dto_Profile profileOpend(String cid) {
	    Jty_Dto_Profile jty_Dto_Profile = null;
	    String query = "SELECT cname, cid, cpassword, cphone, cemail, caddress, cpayPassword ";
	    String query1 = "FROM customer WHERE cid = '" + "wook" + "'";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();

	        ResultSet rs = stmt_mysql.executeQuery(query + query1);

	        while (rs.next()) {
	            String wkcname = rs.getString(1);
	            String wkcid = rs.getString(2);
	            String wkcpassword = rs.getString(3);
	            String wkcphone = rs.getString(4);
	            String wkcemail = rs.getString(5);
	            String wkcaddress = rs.getString(6);
	            String wkcpayPassword = rs.getString(7);
	            

	            jty_Dto_Profile = new Jty_Dto_Profile(wkcname, wkcid, wkcpassword, wkcphone, wkcemail, wkcaddress, wkcpayPassword);
	        }

	        conn_mysql.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        jty_Dto_Profile = null;
	    }
	    return jty_Dto_Profile;
	}
	
	public boolean profileUpdate() {
		PreparedStatement ps = null ;
		try {  // java가 db에 접근했다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			// 로그인창 만든 뒤 경로수정하기
			String query = "update customer set cname = ?, cid = ?, cpassword = ?, cphone = ?, cemail = ?, caddress = ?, cpayPassword = ?";
			String query1 = " where cid = '" + "wook" + "'";
			
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, cname.trim());   // 물음표 2번
			ps.setString(2, cid.trim());
			ps.setString(3, cpassword.trim());
			ps.setString(4, cphone.trim());
			ps.setString(5, cemail.trim());
			ps.setString(6, caddress.trim());   
			ps.setString(7, cpayPassword.trim());   
			
			
			ps.executeUpdate();
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


}
//	            System.out.println("wkcname: " + wkcname);
//	            System.out.println("wkcid: " + wkcid);
//	            System.out.println("wkcpassword: " + wkcpassword);
//	            System.out.println("wkcphone: " + wkcphone);
//	            System.out.println("wkcemail: " + wkcemail);
//	            System.out.println("wkcaddress: " + wkcaddress);
//	            System.out.println("wkcpayPassword: " + wkcpayPassword);
