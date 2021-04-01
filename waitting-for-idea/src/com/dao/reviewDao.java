package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dbconnect.DbConnect;
import com.model.Review;

public class reviewDao {
private Connection conn;
	public reviewDao() {
		conn = DbConnect.getConnection();
	}
	
	public ArrayList<Review> listReview(){
		ArrayList<Review> r = new ArrayList<Review>();
		String sql = "SELECT * FROM review";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
	public ArrayList<Review> listReview(int pId){
		ArrayList<Review> r = new ArrayList<Review>();
		String sql = "SELECT * FROM review WHERE product_id="+pId;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
	public Review getOneById(int id) {
		String sql = "SELECT * FROM review WHERE review_id="+id;
		Review r = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r = new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public boolean insert(Review r) {
		String sql = "INSERT INTO review (product_id,NAME,email,content) value (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getProduct_id());
			ps.setString(2, r.getName());
			ps.setString(3, r.getEmail());
			ps.setString(4, r.getContent());
			return ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Review r) {
		String sql = "UPDATE review SET (product_id,NAME,email,content) value (?,?,?,?) WHERE review_id="+r.getReview_id();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getProduct_id());
			ps.setString(2, r.getName());
			ps.setString(3, r.getEmail());
			ps.setString(4, r.getContent());
			return ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "DELETE FROM review WHERE review_id="+id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
