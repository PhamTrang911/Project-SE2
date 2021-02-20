package com.model;

import java.util.Date;

public class Transaction {
	private int transaction_id;
	private int user_id;
	private String message;
	private float payment;
	private String status;
	private Date created;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public float getPayment() {
		return payment;
	}
	public void setPayment(float payment) {
		this.payment = payment;
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
	public Transaction(int transaction_id, int user_id, String message, float payment, String status, Date created) {
		super();
		this.transaction_id = transaction_id;
		this.user_id = user_id;
		this.message = message;
		this.payment = payment;
		this.status = status;
		this.created = created;
	}
}
