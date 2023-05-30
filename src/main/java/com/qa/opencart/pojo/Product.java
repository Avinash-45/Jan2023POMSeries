package com.qa.opencart.pojo;

public class Product {
	private String searchKey;
	private String productName;
	private int productImages;
	private String productPrice;
	private String brand;

	public Product(String searchKey, String productName, int productImages, String productPrice, String brand) {
		super();
		this.searchKey = searchKey;
		this.productName = productName;
		this.productImages = productImages;
		this.productPrice = productPrice;
		this.brand=brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductImages() {
		return productImages;
	}

	public void setProductImages(int productImages) {
		this.productImages = productImages;
	}

	@Override
	public String toString() {
		return "Product [searchKey=" + searchKey + ", productName=" + productName + ", productImages=" + productImages
				+ "]";
	}

}
