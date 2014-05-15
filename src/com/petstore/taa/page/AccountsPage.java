package com.petstore.taa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountsPage{
	
	@FindBy(how = How.LINK_TEXT, using="Edit Your Account Information")
	private WebElement editAccountLink;
	
	@FindBy(how = How.XPATH, using = "//li[contains(@class,'alert')]")
	private WebElement alertMessage;
	
	@FindBy(how = How.XPATH, using = "//legend[text()='Personal information']/following-sibling::table[1]/tbody/tr[2]/td[2]")
	private WebElement firstName;
	
	public void clickEditYourAccountInformation(){
		editAccountLink.click();
	}
	
	public String getAlertMessage(){
		return alertMessage.getText();
	}
	
	public String getFirstName(){
		return firstName.getText();
	}
	
}
