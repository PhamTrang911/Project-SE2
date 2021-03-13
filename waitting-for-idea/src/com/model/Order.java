package com.model;

import java.util.Date;

public class Order {
	private int ordered_id;
	private int user_id;
	private int product_id;
	private int amount;
	private String message;
	private int discount_id;
	private float totalPayment;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
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
	public Order(int ordered_id, int user_id, int product_id, int amount, String message, int discount_id,
			float totalPayment, String status, Date created) {
		super();
		this.ordered_id = ordered_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.amount = amount;
		this.message = message;
		this.discount_id = discount_id;
		this.totalPayment = totalPayment;
		this.status = status;
		this.created = created;
	}
	public Order(int user_id, int product_id, int amount, String message, int discount_id, float totalPayment,
			String status) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.amount = amount;
		this.message = message;
		this.discount_id = discount_id;
		this.totalPayment = totalPayment;
		this.status = status;
	}
	
}
