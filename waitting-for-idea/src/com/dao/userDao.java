package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.dbconnect.DbConnect;
import com.model.User;

public class userDao {
	private Connection conn;
	public userDao() {
		conn = DbConnect.getConnection();
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
		String sql = "SELECT * FROM users WHERE emai=\""+email+"\"";
		User u = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String dob = rs.getString("dob");
				String address = rs.getString("address");
				String password = rs.getString("password");
				Date created = rs.getDate("created");
				u = new User(id, name, email, phone, dob, address, password, created);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
}
