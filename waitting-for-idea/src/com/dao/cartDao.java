package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dbconnect.DbConnect;
import com.model.Cart;

public class cartDao {
	Connection conn;
	
	public cartDao() {
		conn = DbConnect.getConnection();
	}
	
	public ArrayList<Cart> allInCart(){
		ArrayList<Cart> cs = new ArrayList<Cart>();
		String sql = "SELECT * FROM cart";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cs.add(new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getFloat(5), rs.getString(6), rs.getInt(7), rs.getDate(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cs;
	}
	
	public ArrayList<Cart> allInCartOfUser(int user_id){
		ArrayList<Cart> cs = new ArrayList<Cart>();
		String sql = "SELECT * FROM cart WHERE user_id="+user_id;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cs.add(new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getFloat(5), rs.getString(6), rs.getInt(7), rs.getDate(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cs;
	}
	
	public boolean insert(Cart c) {
		boolean success = false;
		String sql = "INSERT INTO cart (user_id,product_id,product_name,p_price,p_image,quantity) value (?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getUser_id());
			ps.setInt(2, c.getProduct_id());
			ps.setString(3, c.getP_name());
			ps.setFloat(4, c.getP_price());
			ps.setString(5, c.getP_image());
			ps.setInt(6, c.getAmount());
			success = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean update(Cart c) {
		boolean success = false;
		String sql = "UPDATE cart SET amount="+c.getAmount()+" WHERE cart_id="+c.getCart_id();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			success = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean delete(int cart_id) {
		boolean success = false;
		String sql = "DELETE FROM cart WHERE cart_id="+cart_id;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			success = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean clear() {
		boolean success = false;
		String sql = "DELETE FROM cart";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			success = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
}
