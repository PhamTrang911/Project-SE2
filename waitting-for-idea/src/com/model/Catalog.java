package com.model;

public class Catalog {
	private int catalog_id;
	private String name;
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
	public Catalog(int catalog_id, String name) {
		super();
		this.catalog_id = catalog_id;
		this.name = name;
	}
}
