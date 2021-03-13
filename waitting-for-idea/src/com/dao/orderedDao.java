package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dbconnect.DbConnect;
import com.model.Order;

public class orderedDao {
	private Connection conn;
	
	public orderedDao() {
		conn = DbConnect.getConnection();
	}
	
	public ArrayList<Order> listOrder(){
		ArrayList<Order> r = new ArrayList<Order>();
		String sql = "SELECT * FROM ordered";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getDate(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
	public Order getOneById(int id) {
		String sql = "SELECT * FROM ordered WHERE ordered_id="+id;
		Order r = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getDate(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public boolean insert(Order r) {
		String sql = "INSERT INTO ordered (user_id,product_id,amount,message,discount_id,total_payment,STATUS) value (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getUser_id());
			ps.setInt(2, r.getProduct_id());
			ps.setInt(3, r.getAmount());
			ps.setString(4, r.getMessage());
			ps.setInt(5, r.getDiscount_id());
			ps.setFloat(6, r.getTotalPayment());
			ps.setString(7, r.getStatus());
			return ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Order r) {
		String sql = "UPDATE ordered SET (user_id,product_id,amount,message,discount_id,total_payment,STATUS) value (?,?,?,?,?,?,?) WHERE ordered_id="+r.getOrdered_id();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getUser_id());
			ps.setInt(2, r.getProduct_id());
			ps.setInt(3, r.getAmount());
			ps.setString(4, r.getMessage());
			ps.setInt(5, r.getDiscount_id());
			ps.setFloat(6, r.getTotalPayment());
			ps.setString(7, r.getStatus());
			return ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "DELETE FROM ordered WHERE ordered_id="+id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void approveReject(int id, String s) {
		String sql = "UPDATE ordered SET (STATUS) value (?) WHERE ordered_id="+id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
