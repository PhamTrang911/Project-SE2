package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbconnect.DbConnect;

public class adminDao {
Connection conn;
	
	public adminDao() {
		conn = DbConnect.getConnection();
	}
	
	public boolean login(String username, String password) {
		String sql = "SELECT * FROM admin WHERE username=\""+username+"\"";
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

}
