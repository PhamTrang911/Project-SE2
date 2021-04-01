package com.model;

import java.util.Date;

public class Cart {
	private int cart_id;
	private int user_id;
	private int product_id;
	private String p_name;
	private float p_price;
	private String p_image;
	private int amount;
	private Date created;
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public float getP_price() {
		return p_price;
	}
	public void setP_price(float p_price) {
		this.p_price = p_price;
	}
	public Cart(int cart_id, int user_id, int product_id, String p_name, float p_price, String p_image, int amount,
			Date created) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_image = p_image;
		this.amount = amount;
		this.created = created;
	}
	public Cart(int user_id, int product_id, String p_name, float p_price, String p_image, int amount) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_image = p_image;
		this.amount = amount;
	}
	
}
