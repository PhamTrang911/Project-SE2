package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				float amount = rs.getFloat("percentage");
				
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
		String sql = "SELECT * FROM discount WHERE discount_id="+id;
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				float min = rs.getFloat("minPayment");
				float amount = rs.getFloat("percentage");
				
				discount = new Discount(id,name, description, min, amount);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return discount;
	}
	
	public boolean add(Discount d) {
		String sql = "INSERT INTO discount (name,description,minPayment,percentage) value (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getDescription());
			ps.setFloat(3, d.getMinPayment());
			ps.setFloat(4, d.getPercentage());
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(int id,Discount d) {
		String sql = "UPDATE discount SET NAME=?,description=?,minPayment=?,percentage=? WHERE discount_id="+id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getDescription());
			ps.setFloat(3, d.getMinPayment());
			ps.setFloat(4, d.getPercentage());
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "DELETE FROM discount WHERE discount_id="+id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
