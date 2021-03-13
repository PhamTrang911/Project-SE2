package com.model;

import java.util.Date;

public class BroadNew {
	private int broadNew_id;
	private String title;
	private String content;
	private String image_link;
	private String author;
	private Date created;
	
	public int getBroadNew_id() {
		return broadNew_id;
	}
	public void setBroadNew_id(int broadNew_id) {
		this.broadNew_id = broadNew_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public BroadNew(int broadNew_id, String title, String content, String image_link, String author, Date created) {
		super();
		this.broadNew_id = broadNew_id;
		this.title = title;
		this.content = content;
		this.image_link = image_link;
		this.author = author;
		this.created = created;
	}
	public BroadNew(String title, String content, String image_link, String author) {
		super();
		this.title = title;
		this.content = content;
		this.image_link = image_link;
		this.author = author;
	}
}
