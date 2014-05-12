package com.petstore.taa.data;

public class PriceVeryfication {

	private String user;
	private String pass;
	private String category;
	private String product;
	private String item;
	private String expectedPrice;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getExpectedPrice() {
		return expectedPrice;
	}
	public void setExpectedPrice(String expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	
}
