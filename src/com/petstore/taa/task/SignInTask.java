package com.petstore.taa.task;

import org.openqa.selenium.WebDriver;

import com.petstore.taa.page.SignInPage;
import com.petstore.taa.page.WelcomePage;

public class SignInTask {

	private WelcomePage welcomePage;
	private SignInPage signInPage;
	
	public SignInTask(WebDriver webDriver){
		welcomePage = new WelcomePage(webDriver);
		signInPage = new SignInPage(webDriver);
	}
	
	public WelcomePage signInAs(String user, String pass){
		welcomePage
			.clickLogInButton();
		return signInPage
			.enterLogIn(user)
			.enterPassword(pass)
			.clickSignInButton();
	}
	
}
