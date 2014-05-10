package com.petstore.taa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage{

	private By loginField = By.id("j_idt67:login"); 
	private By passwordField = By.id("j_idt67:password"); 
	private By signInButton = By.xpath("//input[@value='Sign In']");
	
	public SignInPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public SignInPage enterLogIn(String value){
		fillText(loginField, value);
		return this;
	}
	
	public SignInPage enterPassword(String value){
		fillText(passwordField, value);
		return this;
	}
	
	public SignInPage clickSignInButton(){
		element(signInButton).click();
		return this;
	}

}
