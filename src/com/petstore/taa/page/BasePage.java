package com.petstore.taa.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver driver;
	private static final String FISH_CATEGORY = "Fish";
	private static final By sideBar = By.className("sidebar-nav");
	private static final By LOG_OUT = By.linkText("Log out");
	private static final By ALERT = By.xpath("//li[contains(@class,'alert')]");
	
	public BasePage(WebDriver webDriver){
		this.driver = webDriver;
	}
	
	protected WebElement element(By locator){
		return driver.findElement(locator);
	}
	
	protected List<WebElement> elements(By locator){
		return driver.findElements(locator);
	}
	
	protected void fillText(By locator, String value){
		element(locator).clear();
		element(locator).sendKeys(value);
	}
	
	public void selectFishCategory(){
		selectCategory(FISH_CATEGORY);
	}
	
	private void selectCategory(String category){
		element(sideBar).findElement(By.linkText(category)).click();
	}
	
	public void logOut(){
		element(LOG_OUT).click();
	}
	
	public String getAlertMessage(){
		return element(ALERT).getText().trim();
	}
	
}
