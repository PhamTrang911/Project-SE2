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
				r.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getDate(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
	public ArrayList<Order> listOrderByUser(int user_id){
		ArrayList<Order> r = new ArrayList<Order>();
		String sql = "SELECT * FROM ordered WHERE user_id="+user_id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getDate(7)));
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
				r = new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getDate(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public boolean insert(Order r) {
		String sql = "INSERT INTO ordered (user_id,cart_ids,total_payment,shipping_address,STATUS) value (?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getUser_id());
			ps.setString(2, r.getCarts());
			ps.setFloat(3, r.getTotalPayment());
			ps.setString(4, r.getShipping_address());
			ps.setString(5, r.getStatus());
			return ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Order r) {
		String sql = "UPDATE ordered SET (user_id,cart_ids,total_payment,shipping_address,STATUS) value (?,?,?,?,?) WHERE ordered_id="+r.getOrdered_id();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getUser_id());
			ps.setString(2, r.getCarts());
			ps.setFloat(3, r.getTotalPayment());
			ps.setString(4, r.getShipping_address());
			ps.setString(5, r.getStatus());
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
		String sql = "UPDATE ordered SET STATUS=\""+s+"\" WHERE ordered_id="+id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
