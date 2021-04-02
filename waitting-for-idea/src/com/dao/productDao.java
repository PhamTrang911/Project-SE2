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
				 String name = rs.getString("NAME");
				 float price = rs.getFloat("price");
				 String status = rs.getString("STATUS");
				 String description = rs.getString("description");
				 float dis = rs.getFloat("discount");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 Product p = new Product(product_id, catalog_id, name, price, status, description, dis, image_link, created);
				 products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public ArrayList<Product> lstProductByNameAsc() {
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product ORDER BY NAME ASC"; 
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				 int product_id = rs.getInt("product_id");
				 int catalog_id = rs.getInt("catalog_id");
				 String name = rs.getString("NAME");
				 float price = rs.getFloat("price");
				 String status = rs.getString("STATUS");
				 String description = rs.getString("description");
				 float dis = rs.getFloat("discount");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 Product p = new Product(product_id, catalog_id, name, price, status, description, dis, image_link, created);
				 products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	public ArrayList<Product> lstProductByNameDes() {
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product ORDER BY NAME DESC"; 
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				 int product_id = rs.getInt("product_id");
				 int catalog_id = rs.getInt("catalog_id");
				 String name = rs.getString("NAME");
				 float price = rs.getFloat("price");
				 String status = rs.getString("STATUS");
				 String description = rs.getString("description");
				 float dis = rs.getFloat("discount");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 Product p = new Product(product_id, catalog_id, name, price, status, description, dis, image_link, created);
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
		String sql = "SELECT * FROM product WHERE product_id="+id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int product_id = rs.getInt("product_id");
				 int catalog_id = rs.getInt("catalog_id");
				 String name = rs.getString("NAME");
				 float price = rs.getFloat("price");
				 String status = rs.getString("STATUS");
				 String description = rs.getString("description");
				 float dis = rs.getFloat("discount");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 p = new Product(product_id, catalog_id, name, price, status, description, dis, image_link, created);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public  ArrayList<Product> getProductByName(String sname) {
		 ArrayList<Product> p = null;
		String sql = "SELECT * FROM product WHERE NAME="+"\""+sname+"\"";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int product_id = rs.getInt("product_id");
				 int catalog_id = rs.getInt("catalog_id");
				 String name = rs.getString("NAME");
				 float price = rs.getFloat("price");
				 String status = rs.getString("STATUS");
				 String description = rs.getString("description");
				 float dis = rs.getFloat("discount");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 p.add(new Product(product_id, catalog_id, name, price, status, description, dis, image_link, created));
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
				 String name = rs.getString("NAME");
				 float price = rs.getFloat("price");
				 String status = rs.getString("STATUS");
				 String description = rs.getString("description");
				 float dis = rs.getFloat("discount");
				 String image_link = rs.getString("image_link");
				 Date created = rs.getDate("created");
				 
				 Product p = new Product(product_id, catalog_id, name, price, status, description, dis, image_link, created);
				 lst.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}
	
	public void insertProduct(Product p) {
		String sql = "INSERT INTO product (catalog_id,NAME,price,STATUS,description,discount,image_link) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getCatalog_id());
			ps.setString(2, p.getName());
			ps.setFloat(3, p.getPrice());
			ps.setString(4, p.getStatus());
			ps.setString(5, p.getDescription());
			ps.setFloat(6, p.getDiscount());
			ps.setString(7, p.getImage_link());
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateProduct(Product p){
		String sql = "UPDATE product SET catalog_id= ?,NAME= ?,price= ?,STATUS= ?,description= ?,discount= ?,image_link= ? WHERE product_id="+p.getProduct_id();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getCatalog_id());
			ps.setString(2, p.getName());
			ps.setFloat(3, p.getPrice());
			ps.setString(4, p.getStatus());
			ps.setString(5, p.getDescription());
			ps.setFloat(6, p.getDiscount());
			ps.setString(7, p.getImage_link());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(int pid) {
		String sql = "DELETE FROM product WHERE product_id="+pid;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
