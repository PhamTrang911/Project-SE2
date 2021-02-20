package com.model;

import java.util.Date;

public class BroadNew {
	private int broadNew_id;
	private int product_id;
	private String name;
	private String email;
	private String content;
	private Date created;
	public int getBroadNew_id() {
		return broadNew_id;
	}
	public void setBroadNew_id(int broadNew_id) {
		this.broadNew_id = broadNew_id;
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
	public BroadNew(int broadNew_id, int product_id, String name, String email, String content, Date created) {
		super();
		this.broadNew_id = broadNew_id;
		this.product_id = product_id;
		this.name = name;
		this.email = email;
		this.content = content;
		this.created = created;
	}
}
