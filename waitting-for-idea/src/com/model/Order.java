package com.model;

import java.util.Date;

public class Order {
	private int ordered_id;
	private int user_id;
	private String carts;
	private float totalPayment;
	private String shipping_address;
	private String status;
	private Date created;
	public int getOrdered_id() {
		return ordered_id;
	}
	public void setOrdered_id(int ordered_id) {
		this.ordered_id = ordered_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCarts() {
		return carts;
	}
	public void setCarts(String carts) {
		this.carts = carts;
	}
	public float getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(float totalPayment) {
		this.totalPayment = totalPayment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public Order(int ordered_id, int user_id, String carts, float totalPayment, String shipping_address, String status,
			Date created) {
		super();
		this.ordered_id = ordered_id;
		this.user_id = user_id;
		this.carts = carts;
		this.totalPayment = totalPayment;
		this.shipping_address = shipping_address;
		this.status = status;
		this.created = created;
	}
	public Order(int user_id, String carts, float totalPayment, String shipping_address, String status) {
		super();
		this.user_id = user_id;
		this.carts = carts;
		this.totalPayment = totalPayment;
		this.shipping_address = shipping_address;
		this.status = status;
	}
	
}
