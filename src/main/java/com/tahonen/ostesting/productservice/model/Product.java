package com.tahonen.ostesting.productservice.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private long id;
	private String name;
	private String description;
	private List<ProductItem> items;

	public Product(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void addItem(ProductItem item) {
		this.getItems().add(item);
	}

	public List<ProductItem> getItems() {
		if (this.items == null) {
			this.items = new ArrayList<ProductItem>();
		}
		return items;
	}

	public void setItems(List<ProductItem> items) {
		this.items = items;
	}

}
