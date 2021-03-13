package com.model;

public class Discount {
	private int discount_id;
	private String name;
	private String description;
	private float minPayment;
	private float percentage;
	public int getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getMinPayment() {
		return minPayment;
	}
	public void setMinPayment(float minPayment) {
		this.minPayment = minPayment;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public Discount(int discount_id, String name, String description, float minPayment, float percentage) {
		super();
		this.discount_id = discount_id;
		this.name = name;
		this.description = description;
		this.minPayment = minPayment;
		this.percentage = percentage;
	}
	public Discount(String name, String description, float minPayment, float percentage) {
		super();
		this.name = name;
		this.description = description;
		this.minPayment = minPayment;
		this.percentage = percentage;
	}
	
}
