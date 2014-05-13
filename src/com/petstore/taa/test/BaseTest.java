package com.petstore.taa.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.petstore.taa.page.BasePage;


public abstract class BaseTest {

	protected WebDriver driver;
	protected String baseUrl;

	@Before
	public void init() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
		driver = new FirefoxDriver(profile);
		baseUrl = "http://kozon.pl:8080/";
//		driver.manage().timeouts().implicitlyWait(-1, TimeUnit.SECONDS).pageLoadTimeout(-1, TimeUnit.SECONDS).setScriptTimeout(-1, TimeUnit.SECONDS);
		driver.get(baseUrl + "/applicationPetstore/main.xhtml");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	//onPage
	protected <T extends BasePage> T onPage(T page) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(page.pageUniqueLocator()));
		return page;
	} 
}
