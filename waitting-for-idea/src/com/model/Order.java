package com.model;

public class Order {
	private int ordered_id;
	private int product_id;
	private int transaction_id;
	public int getOrdered_id() {
		return ordered_id;
	}
	public void setOrdered_id(int ordered_id) {
		this.ordered_id = ordered_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Order(int ordered_id, int product_id, int transaction_id) {
		super();
		this.ordered_id = ordered_id;
		this.product_id = product_id;
		this.transaction_id = transaction_id;
	}
	
}
