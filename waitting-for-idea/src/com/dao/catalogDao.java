package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dbconnect.DbConnect;
import com.model.Catalog;

public class catalogDao {
	
private Connection conn;

	public catalogDao() {
		conn = DbConnect.getConnection();
	}
	
	public ArrayList<Catalog> listCatalog(){
		ArrayList<Catalog> lst = new ArrayList<Catalog>();
		String sql = "SELECT * FROM catalog";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("catalog_id");
				String name = rs.getString("NAME");
				
				Catalog c = new Catalog(id, name);
				lst.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	public Catalog getNameById(int id) {
		String sql = "SELECT * FROM catalog WHERE catalog_id = "+id;
		String name = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Catalog(id, name);
	}
	
	public boolean insert(String name) {
		String sql = "INSERT INTO catalog (NAME) value ("+name+")";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(int id, String name) {
		String sql = "UPDATE catalog SET NAME=\""+name+"\" WHERE catalog_id="+id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "DELETE FROM catalog WHERE catalog_id="+id;
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
