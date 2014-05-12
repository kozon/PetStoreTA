package com.petstore.taa.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public abstract class BaseTest {

	protected WebDriver driver;
	protected String baseUrl;

	@Before
	public void init() {
		driver = new FirefoxDriver();
		baseUrl = "http://kozon.pl:8080/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl + "/applicationPetstore/main.xhtml");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
