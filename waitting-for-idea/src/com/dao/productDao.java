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
	
	public ArrayList<Product> lstProduct() {
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product"; 
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				 int product_id = rs.getInt("product_id");
				 int catalog_id = rs.getInt("catalog_id");
				 String name = rs.getString("name");
				 float price = rs.getFloat("price");
				 String status = rs.getString("status");
				 String description = rs.getString("description");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 Product p = new Product(product_id, catalog_id, name, price, status, description, image_link, created);
				 products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public Product getProductById(int id) {
		Product p = null;
		String sql = "SELECT * FROM product WHERE name="+"\""+id+"\"";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int product_id = rs.getInt("product_id");
				 int catalog_id = rs.getInt("catalog_id");
				 String name = rs.getString("name");
				 float price = rs.getFloat("price");
				 String status = rs.getString("status");
				 String description = rs.getString("description");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 p = new Product(product_id, catalog_id, name, price, status, description, image_link, created);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public Product getProductByName(String sname) {
		Product p = null;
		String sql = "SELECT * FROM product WHERE name="+"\""+sname+"\"";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int product_id = rs.getInt("product_id");
				 int catalog_id = rs.getInt("catalog_id");
				 String name = rs.getString("name");
				 float price = rs.getFloat("price");
				 String status = rs.getString("status");
				 String description = rs.getString("description");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 p = new Product(product_id, catalog_id, name, price, status, description, image_link, created);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}
	
	public ArrayList<Product> getProductByCatalog(int catalog_id) {
		ArrayList<Product> lst = new ArrayList<Product>();
		
		String sql = "SELECT * FROM product WHERE catalog_id="+catalog_id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int product_id = rs.getInt("product_id");
				 String name = rs.getString("name");
				 float price = rs.getFloat("price");
				 String status = rs.getString("status");
				 String description = rs.getString("description");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 Product p = new Product(product_id, catalog_id, name, price, status, description, image_link, created);
				 lst.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}
	
	public void insertProduct(Product p) {
		String sql = "INSERT INTO product (catalog_id,name,price,status,description,discount,image_link,created) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getCatalog_id());
			ps.setString(2, p.getName());
			ps.setFloat(3, p.getPrice());
			ps.setString(4, p.getStatus());
			ps.setString(5, p.getDescription());
			ps.setString(7, p.getImage_link());
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateProduct(Product p){
		String sql = "UPDATE product SET catalog_id="+p.getCatalog_id()+",name="+p.getName()+",price="+p.getPrice()+",status="+p.getStatus()+",description="+p.getDescription()+",image_link="+p.getImage_link()+"WHERE product_id="+p.getProduct_id();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
