package com.petstore.taa.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	private WebDriver webDriver;
	private static final String FISH_CATEGORY = "Fish";
	private static final By sideBar = By.className("sidebar-nav");
	private static final By LOG_OUT = By.linkText("Log out");
	private static final By ALERT = By.xpath("//li[contains(@class,'alert')]");
	
	private By uniquePageElement;
	
	protected BasePage(WebDriver webDriver, By elementLocator){
		this.webDriver = webDriver;
		this.uniquePageElement = elementLocator;
	}
	
	protected WebElement element(By locator){
		return webDriver.findElement(locator);
	}
	
	protected List<WebElement> elements(By locator){
		return webDriver.findElements(locator);
	}
	
	protected void fillText(By locator, String value){
		element(locator).clear();
		element(locator).sendKeys(value);
	}
	
	public void selectFishCategory(){
		selectCategory(FISH_CATEGORY);
	}
	
	public ProductsForCategoryPage selectCategory(String category){
		element(sideBar).findElement(By.linkText(category)).click();
		return onPage(new ProductsForCategoryPage(webDriver));
	}
	
	public void logOut(){
		element(LOG_OUT).click();
	}
	
	public String getAlertMessage(){
		return element(ALERT).getText().trim();
	}
	
	protected WebDriver getDriver(){
		return webDriver;
	}
	
	public By pageUniqueLocator(){
		return uniquePageElement;
	}
	
	public <T extends BasePage> T onPage(T page) {
		(new WebDriverWait(webDriver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(page.pageUniqueLocator()));
		return page;
	} 
	
}