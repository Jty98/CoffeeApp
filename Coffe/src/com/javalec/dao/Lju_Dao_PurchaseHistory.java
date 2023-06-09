package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.Lju_dto;
import com.javalec.util.ShareVar;

public class Lju_Dao_PurchaseHistory {

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	
	
	String pdate;
	String iname;
	int pqty;
	int psaleprice;
	int pSeq;
	String discount; 
	
	public Lju_Dao_PurchaseHistory() {
		// TODO Auto-generated constructor stub
	}

	public Lju_Dao_PurchaseHistory(String discount) {
		super();
		this.discount = discount;
	}

	public Lju_Dao_PurchaseHistory(String pdate, String iname, int pqty, int psaleprice, int pSeq) {
		super();
		this.pdate = pdate;
		this.iname = iname;
		this.pqty = pqty;
		this.psaleprice = psaleprice;
		this.pSeq = pSeq;
	}
	
	
	
	public ArrayList<Lju_dto> History(){
		ArrayList<Lju_dto> dtoList = new ArrayList<Lju_dto>();
		
		String whereDefault = "select p.pdate, sum(p.pqty), sum(p.pqty*p.psaleprice), (select max(i.iname)), (select max(i.iimagename)),(select min(i.iimage))";
		String whereDefault1 = " from customer c, item i, purchase p";
		String whereDefault2 = " where c.cid = p.customer_cid and i.iid = p.item_iid and cid = '"+ ShareVar.loginUserId +"'";
		String whereDefault3 = " group by pdate order by pdate desc";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault+whereDefault1+whereDefault2+whereDefault3);

			while(rs.next()) {
				String pdate = rs.getString(1);
				int pqty = rs.getInt(2);
				int psaleprice = rs.getInt(3);
				String iname = rs.getString(4);
				String iimagename = rs.getString(5);
				
				File file = new File("./" + iimagename);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(6);
				
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				Lju_dto dto = new Lju_dto(pdate, iname, pqty, psaleprice, iimagename);
				dtoList.add(dto);
			}
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
	}
		return dtoList;
	
}
	
	public boolean purchaseAciont() {
		PreparedStatement ps = null;
		PreparedStatement pss = null;
		PreparedStatement psCoupon = null;
		String coupon = "";
		String dis;
		int j = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			if(discount.equals("10% 할인 쿠폰")) {
				dis = "0.90";
				coupon = "update coupon set cUse = 1 where customer_cid = '"+ShareVar.loginUserId+"'";
			}else if(discount.equals("9% 할인 쿠폰")) {
				dis = "0.91";
				coupon = "update coupon set cUse = 1 where customer_cid = '"+ShareVar.loginUserId+"'";
			}else if(discount.equals("8% 할인 쿠폰")) {
				dis = "0.92";
				coupon = "update coupon set cUse = 1 where customer_cid = '"+ShareVar.loginUserId+"'";
			}else if(discount.equals("7% 할인 쿠폰")) {
				dis = "0.93";
				coupon = "update coupon set cUse = 1 where customer_cid = '"+ShareVar.loginUserId+"'";
			}else if(discount.equals("6% 할인 쿠폰")) {
				dis = "0.94";
				coupon = "update coupon set cUse = 1 where customer_cid = '"+ShareVar.loginUserId+"'";
			}else if(discount.equals("5% 할인 쿠폰")) {
				dis = "0.95";
				coupon = "update coupon set cUse = 1 where customer_cid = '"+ShareVar.loginUserId+"'";
			}else {
				dis = "1";
				j = Integer.parseInt(dis);
				
			}
			
		
				String query = "insert into purchase (item_iid, customer_cid, pqty, pdate, psaleprice)";
				String query1 = " select b.item_iid, b.customer_cid, b.bqty, now(), i.iprice*"+ dis +" from basket b, item i, customer c ";
				String query2 = " where c.cid = b.customer_cid and i.iid = b.item_iid and cid = '"+ShareVar.loginUserId +"'";
				String q = "delete from basket where customer_cid = '" + ShareVar.loginUserId + "'";
				ps = conn_mysql.prepareStatement(query + query1 + query2);
				pss = conn_mysql.prepareStatement(q);
				ps.executeUpdate();
				pss.executeUpdate();
				
				if(j == 1) {
					
				}else {
					psCoupon = conn_mysql.prepareStatement(coupon);
					psCoupon.executeUpdate();
					
				}
				conn_mysql.close();	
				
				
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	
	
}
