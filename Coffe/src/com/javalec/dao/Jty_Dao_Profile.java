package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
	    String query1 = "FROM customer WHERE cid = '" + cid + "'";

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
	            
	            System.out.println("wkcname: " + wkcname);
	            System.out.println("wkcid: " + wkcid);
	            System.out.println("wkcpassword: " + wkcpassword);
	            System.out.println("wkcphone: " + wkcphone);
	            System.out.println("wkcemail: " + wkcemail);
	            System.out.println("wkcaddress: " + wkcaddress);
	            System.out.println("wkcpayPassword: " + wkcpayPassword);

	            jty_Dto_Profile = new Jty_Dto_Profile(wkcname, wkcid, wkcpassword, wkcphone, wkcemail, wkcaddress, wkcpayPassword);
	        }

	        conn_mysql.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return jty_Dto_Profile;
	}

		
	
	public ArrayList<Jty_Dto_Profile> selectList() { // <타입>
		ArrayList<Jty_Dto_Profile> dtoList = new ArrayList<Jty_Dto_Profile>();

		String whereDefault = "select cname, cid, cpassword, cpassword, cphone, cemail, caddress, cpayPassword";
		String whereDefault1 = "from customer where cid = '" + cid + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 데이터 연결 정의
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault + whereDefault1); // 결과값을 불러오기

			// 검색시작
			while (rs.next()) { // 읽을데이터가 없으면 빠진다
				String wkcname = rs.getString(1);
				String wkcid = rs.getString(2);
				String wkcpassword = rs.getString(3);
				String wkcpassword1 = rs.getString(4);
				String wkcphone = rs.getString(4);
				String wkcemail = rs.getString(5);
				String wkcaddress = rs.getString(6);
				String wkcpayPassword = rs.getString(7);
				
				  System.out.println("wkcname: " + wkcname);
				    System.out.println("wkcid: " + wkcid);
				    System.out.println("wkcpassword: " + wkcpassword);
				    System.out.println("wkcphone: " + wkcphone);
				    System.out.println("wkcemail: " + wkcemail);
				    System.out.println("wkcaddress: " + wkcaddress);
				    System.out.println("wkcpayPassword: " + wkcpayPassword);

				// 데이터를 불러와서 한번에 넣어주는부분 (배열 한칸에 wkSeq, wkName, wkTelno, wkRelation이 들어가있음)
				Jty_Dto_Profile jty_Dto_Profile = new Jty_Dto_Profile(wkcname, wkcid, wkcpassword, wkcphone, wkcemail, wkcaddress, wkcpayPassword);
				dtoList.add(jty_Dto_Profile);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;

	}

}
