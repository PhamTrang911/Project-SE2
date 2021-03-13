package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dbconnect.DbConnect;
import com.model.Admin;

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
				if(rs.getString("PASSWORD").equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insert(String u, String p){
		boolean success = false;
		String sql = "INSERT INTO admin (username,PASSWORD) value (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u);
			ps.setString(2, p);
			success = ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	}
	
	public boolean update(Admin a) {
		String sql = "UPDATE admin SET username=\""+a.getUsername()+"\", PASSWORD=\""+a.getPassword()+"\" WHERE id="+a.getId();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(String username) {
		String sql = "DELETE FROM admin WHERE username=\""+username+"\"";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Admin> listAdmin(){
		ArrayList<Admin> a = new ArrayList<Admin>();
		String sql = "SELECT * FROM admin";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a.add(new Admin(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public Admin getAdmin(String parameter) {
		Admin a = null;
		String sql = "SELECT * FROM admin WHERE username=\""+parameter+"\"";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

}
