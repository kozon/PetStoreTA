package com.petstore.taa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UpdateAccountPage{
	
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'firstname')]")
	private WebElement firstName;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	private WebElement submit;

	public UpdateAccountPage enterFirstName(String value){
		firstName.clear();
		firstName.sendKeys(value);
		return this;
	}
	
	public void submit(){
		submit.click();
	}
}
