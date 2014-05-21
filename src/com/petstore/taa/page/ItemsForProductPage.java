package com.petstore.taa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsForProductPage extends BasePage{

	private static final String ADD_TO_CART = "Add to Cart";
	private static final By ADD_TO_CART_DIRECT_LINK = By.linkText(ADD_TO_CART);
	private static final String ADD_TO_CART_BY_PRODUCT_PATTERN  = "//a[text()='%s']/ancestor::div[@class='media']//a[text()='"+ADD_TO_CART+"']";
	private static final String ITEM_LINK_PATTERN_ALT = "//tbody/tr[%s]//h3/a";
	
	public ItemsForProductPage(WebDriver webDriver) {
		super(webDriver, By.xpath("//h2[text()[contains(.,'Items for product : ')]]"));
	}
	
	public void addToCart(int index){
		elements(ADD_TO_CART_DIRECT_LINK).get(index).click();
	}
	
	public ShoppingCartPage addToCart(String product){
		element(By.xpath(String.format(ADD_TO_CART_BY_PRODUCT_PATTERN, product))).click();
		return onPage(new ShoppingCartPage(getDriver()));
	}
	
	public void selectItem(int index){
		WebElement element = element(By.xpath(String.format(ITEM_LINK_PATTERN_ALT, index)));
		element.click();
	}
	
}
