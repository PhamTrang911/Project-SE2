package com.model;

import java.util.Date;

public class Cart {
	private int cart_id;
	private int user_id;
	private int product_id;
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
	public Cart(int cart_id, int user_id, int product_id, int amount, Date created) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.amount = amount;
		this.created = created;
	}
	public Cart(int user_id, int product_id, int amount) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.amount = amount;
	}
	
}
