package com.petstore.taa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemsForProductPage extends BasePage{

	private static final String ADD_TO_CART = "Add to Cart";
	private static final By ADD_TO_CART_DIRECT_LINK = By.linkText(ADD_TO_CART);
	private static final String ADD_TO_CART_BY_PRODUCT_PATTERN  = "//a[text()='%s']/ancestor::div[@class='media']//a[text()='"+ADD_TO_CART+"']";
	
	public ItemsForProductPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void addToCart(int index){
		elements(ADD_TO_CART_DIRECT_LINK).get(index).click();
	}
	
	public void addToCart(String product){
		element(By.xpath(String.format(ADD_TO_CART_BY_PRODUCT_PATTERN, product))).click();
	}
	
}
