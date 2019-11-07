package com.hcql;

public class Sales {

	private int id;
	private String productName;
	private float price;

	public Sales() {

	}

	public Sales(int id, String productName, float price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}

}