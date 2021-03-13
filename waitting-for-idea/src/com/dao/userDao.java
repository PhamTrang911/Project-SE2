package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.dbconnect.DbConnect;
import com.model.User;

public class userDao {
	private Connection conn;
	public userDao() {
		conn = DbConnect.getConnection();
	}
	
	public ArrayList<User> listUser() {
		String sql = "SELECT * FROM users";
		ArrayList<User> us = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("NAME");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String dob = rs.getString("dob");
				String address = rs.getString("address");
				String password = rs.getString("PASSWORD");
				Date created = rs.getDate("created");
				us.add(new User(id, name, email, phone, dob, address, password, created));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
	}

	public boolean login(String email, String password) {
		String sql = "SELECT * FROM users WHERE email=\""+email+"\"";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("password").equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public User getUserByEmail(Object attribute) {
		String email = (String) attribute;
		String sql = "SELECT * FROM users WHERE email=\""+email+"\"";
		User u = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("NAME");
				String phone = rs.getString("phone");
				String dob = rs.getString("dob");
				String address = rs.getString("address");
				String password = rs.getString("PASSWORD");
				Date created = rs.getDate("created");
				u = new User(id, name, email, phone, dob, address, password, created);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	public boolean insertUser(User u) {
		String sql = "UPDATE INTO users (NAME,email,phone,dob,address,PASSWORD) value (?,?,?,?,?,?)";
		boolean created = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPhone());
			ps.setString(4, u.getDob());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getPassword());
			created = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return created;
	}
	
	public boolean updateUser(User u) {
		String sql = "UPDATE users SET (NAME,phone,dob,address,PASSWORD) value (?,?,?,?,?) WHERE email="+u.getEmail();
		boolean created = false;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPhone());
			ps.setString(3, u.getDob());
			ps.setString(4, u.getAddress());
			ps.setString(5, u.getPassword());
			created = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return created;
	}
	
	public boolean deleteUser(String email) {
		String sql = "DELETE FROM users WHERE email=\""+email+"\"";
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
