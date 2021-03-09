package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dbconnect.DbConnect;
import com.model.Discount;

public class discountDao {
	private Connection conn;
	
	public discountDao() {
		conn = DbConnect.getConnection();
	}
	
	public ArrayList<Discount> listDiscount(){
		ArrayList<Discount> discount = new ArrayList<Discount>();
		String sql = "SELECT * FROM discount";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("discount_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				float min = rs.getFloat("minPayment");
				float amount = rs.getFloat("amount");
				
				Discount d = new Discount(id,name, description, min, amount);
				discount.add(d);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return discount;
	}
	
	public Discount getById(int id) {
		Discount discount = null;
		String sql = "SELECT * FROM discount WHERE id="+id;
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				float min = rs.getFloat("minPayment");
				float amount = rs.getFloat("amount");
				
				discount = new Discount(id,name, description, min, amount);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return discount;
	}
}
