package com.petstore.taa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage{

	private static final By LOG_IN_BUTTON = By.linkText("Log in");
	private static final By WELCOME_LINK = By.xpath("//ul[@class='nav']/li/a[contains(text(), 'Welcome')]");
	
	public WelcomePage(WebDriver webDriver) {
		super(webDriver, By.xpath("//img[@alt='Welcome to YAPS PetStore']"));
	}
	
	public SignInPage clickLogInButton(){
		element(LOG_IN_BUTTON).click();
		return onPage(new SignInPage(getDriver()));
	}
	
	public void navigateToAccountsPage(){
		element(WELCOME_LINK).click();
	}
	
}
