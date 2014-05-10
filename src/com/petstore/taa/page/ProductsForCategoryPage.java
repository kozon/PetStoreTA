package com.petstore.taa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsForCategoryPage extends BasePage{

	private static final String PRODUCT_LINK_PATTERN = "//h3/a[text()='%s']";
	
	public ProductsForCategoryPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void selectProduct(String productName){
		element(By.xpath(String.format(PRODUCT_LINK_PATTERN, productName))).click();;
	}
	
}
