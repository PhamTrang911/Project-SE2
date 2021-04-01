package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dbconnect.DbConnect;
import com.model.BroadNew;

public class broadnewDao {
	private Connection conn;
	public broadnewDao() {
		conn = DbConnect.getConnection();
	}
	
	public ArrayList<BroadNew> listBroadnew(){
		ArrayList<BroadNew> bn = new ArrayList<BroadNew>();
		String sql = "SELECT * FROM broardnew";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bn.add(new BroadNew(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bn;
	}
	
	public BroadNew getOneById(int id) {
		String sql = "SELECT * FROM broardnew WHERE broadnew_id="+id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new BroadNew(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean insert(BroadNew bn) {
		String sql = "INSERT INTO broardnew (title,content,image_link,author) value (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bn.getTitle());
			ps.setString(2, bn.getContent());
			ps.setString(3, bn.getImage_link());
			ps.setString(4, bn.getAuthor());
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(BroadNew bn) {
		String sql = "UPDATE broardnew SET title=?,content=?,image_link=?,author=? WHERE broadnew_id="+bn.getBroadNew_id();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bn.getTitle());
			ps.setString(2, bn.getContent());
			ps.setString(3, bn.getImage_link());
			ps.setString(4, bn.getAuthor());
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "DELETE FROM broardnew WHERE broadnew_id="+id;
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
