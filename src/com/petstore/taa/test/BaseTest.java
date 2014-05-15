package com.petstore.taa.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.petstore.taa.page.BasePage;


public abstract class BaseTest {

	protected WebDriver webDriver;
	protected String baseUrl;

	@Before
	public void init() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
		webDriver = new FirefoxDriver(profile);
		baseUrl = "http://kozon.pl:8080/";
		webDriver.get(baseUrl + "/applicationPetstore/main.xhtml");
	}

	@After
	public void tearDown() throws Exception {
		webDriver.quit();
	}
	
	protected <T extends BasePage> T onPage(T page) {
		(new WebDriverWait(webDriver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(page.pageUniqueLocator()));
		return page;
	} 
}
