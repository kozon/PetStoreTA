package com.petstore.taa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{

	private static final By TOTAL_TEXT = By.xpath("//a[text()='Check Out']//parent::div");
	private static final String TABLE_ROW_PATTERN = "//table//tr[%s]";
	private static final String QUANTITY_FIELD_PATTERN = TABLE_ROW_PATTERN+"//input";
	private static final String UPDATE_BUTTON_PATTERN = TABLE_ROW_PATTERN+"//a[text()='Update']";
	private static final String REMOVE_BUTTON_PATTERN = TABLE_ROW_PATTERN+"//a[text()='Remove']";
	
	public ShoppingCartPage(WebDriver webDriver) {
		super(webDriver, By.xpath("//h2[text()='Shopping Cart']"));
	}
	
	public String getTotal(){
		return element(TOTAL_TEXT).getText()
				.replaceAll("Check Out", "")
				.replaceAll("Total", "")
				.trim();
	}
	
	public ShoppingCartPage enterQuantity(int rowIndex, String value){
		fillText(By.xpath(String.format(QUANTITY_FIELD_PATTERN, rowIndex)), value);
		return this;
	}
	
	public ShoppingCartPage clickUpdateQuantity(int rowIndex){
		element(By.xpath(String.format(UPDATE_BUTTON_PATTERN, rowIndex))).click();
		return this;
	}
	
	public ShoppingCartPage clickRemove(int rowIndex){
		element(By.xpath(String.format(REMOVE_BUTTON_PATTERN, rowIndex))).click();
		return this;
	}
	
}
