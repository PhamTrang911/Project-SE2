package com.model;

import java.util.Date;

public class Review {
	private int review_id;
	private int product_id;
	private String name;
	private String email;
	private String content;
	private Date created;
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Review(int review_id, int product_id, String name, String email, String content, Date created) {
		super();
		this.review_id = review_id;
		this.product_id = product_id;
		this.name = name;
		this.email = email;
		this.content = content;
		this.created = created;
	}
	public Review(int product_id, String name, String email, String content) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.email = email;
		this.content = content;
	}

}
