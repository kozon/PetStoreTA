package com.petstore.taa.page;

import javax.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage{

	private static final By logInButton = By.linkText("Log in");
	
	@Inject
	public WelcomePage(WebDriver webDriver) {
		super(webDriver, By.xpath("//img[@alt='Welcome to YAPS PetStore']"));
	}
	
	public void clickLogInButton(){
		element(logInButton).click();
	}
	
}
