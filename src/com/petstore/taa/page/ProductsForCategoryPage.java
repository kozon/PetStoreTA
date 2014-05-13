package com.petstore.taa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsForCategoryPage extends BasePage{

	private static final String PRODUCT_LINK_PATTERN = "//h3/a[text()='%s']";
	private static final String PRODUCT_LINK_PATTERN_ALT = "//tbody/tr[%s]//h3/a";
	
	public ProductsForCategoryPage(WebDriver webDriver) {
		super(webDriver, By.xpath("//h2[text()[contains(.,'Products for category : ')]]"));
	}
	
	public void selectProduct(String productName){
		element(By.xpath(String.format(PRODUCT_LINK_PATTERN, productName))).click();
	}
	
	public ProductsForCategoryPage selectProduct(int index){
		WebElement element = element(By.xpath(String.format(PRODUCT_LINK_PATTERN_ALT, index)));
		element.click();
		return this;
	}
	
}
