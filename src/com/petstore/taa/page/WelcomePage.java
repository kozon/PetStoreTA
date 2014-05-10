package com.petstore.taa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage{

	private static final By logInButton = By.linkText("Log in");
	
	public WelcomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void clickLogInButton(){
		element(logInButton).click();
	}

}
