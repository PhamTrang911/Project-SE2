package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.dbconnect.DbConnect;
import com.model.Product;

public class productDao {
	Connection conn;
	
	public productDao() {
		conn = DbConnect.getConnection();
	}
	
	public ArrayList<Product> lstProduct() throws SQLException{
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product"; 
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			 int product_id = rs.getInt("product_id");
			 int catalog_id = rs.getInt("catalog_id");
			 String name = rs.getString("name");
			 float price = rs.getFloat("price");
			 String status = rs.getString("status");
			 String description = rs.getString("description");
			 int discount = rs.getInt("discount");
			 String image_link = rs.getString("image_link");
			 Date created = rs.getDate("created");
			 
			 Product p = new Product(product_id, catalog_id, name, price, status, description, discount, image_link, created);
			 products.add(p);
		}
		
		return products;
	}
	
	public Product getProductByName(String sname) throws SQLException {
		Product p = null;
		String sql = "SELECT * FROM product WHERE name="+"\""+sname+"\"";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int product_id = rs.getInt("product_id");
			 int catalog_id = rs.getInt("catalog_id");
			 String name = rs.getString("name");
			 float price = rs.getFloat("price");
			 String status = rs.getString("status");
			 String description = rs.getString("description");
			 int discount = rs.getInt("discount");
			 String image_link = rs.getString("image_link");
			 Date created = rs.getDate("created");
			 
			 p = new Product(product_id, catalog_id, name, price, status, description, discount, image_link, created);
		}
		return p;
	}
	
	public void insertProduct(Product p) throws SQLException {
		String sql = "INSERT INTO product (catalog_id,name,price,status,description,discount,image_link,created) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, p.getCatalog_id());
		ps.setString(2, p.getName());
		ps.setFloat(3, p.getPrice());
		ps.setString(4, p.getStatus());
		ps.setString(5, p.getDescription());
		ps.setInt(6, p.getDiscount());
		ps.setString(7, p.getImage_link());
	}
}
