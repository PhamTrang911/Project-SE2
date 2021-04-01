package com.model;

import java.util.Date;

public class Product implements Comparable<Product>{
	private int product_id;
	private int catalog_id;
	private String name;
	private float price;
	private String status;
	private String description;
	private float discount;
	private String image_link;
	private Date created;
	
	public Product(int catalog_id, String name, float price, String status, String description, float discount,
			String image_link) {
		super();
		this.catalog_id = catalog_id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.description = description;
		this.discount = discount;
		this.image_link = image_link;
	}
	public Product(int product_id, int catalog_id, String name, float price, String status, String description,
			float discount, String image_link, Date created) {
		super();
		this.product_id = product_id;
		this.catalog_id = catalog_id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.description = description;
		this.discount = discount;
		this.image_link = image_link;
		this.created = created;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	@Override
	public int compareTo(Product o) {
		return this.name.compareToIgnoreCase(o.getName());
	}
	
}
