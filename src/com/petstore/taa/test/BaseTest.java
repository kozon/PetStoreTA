package com.petstore.taa.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.petstore.taa.page.BasePage;


public abstract class BaseTest {

	private Properties prop = new Properties();
	protected WebDriver webDriver;

	@Before
	public void init() throws IOException {
		loadProperties();
		boolean isSauce = Boolean.parseBoolean(getProperty("isSauce"));
		if (!isSauce){ 
			localEnvInit();
		}else{
			sauceLabsInit();
		}
		webDriver.get(getProperty("baseUrl")+ getProperty("appName"));
	}
	
	private void localEnvInit(){
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
		webDriver = new FirefoxDriver(profile);
	}
	
	private void sauceLabsInit() throws MalformedURLException{
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("platform", Platform.XP);
        capabilities.setCapability("name", this.getClass().getName());
        this.webDriver = new RemoteWebDriver(
                new URL("http://"+getProperty("sauceUser")+":"+getProperty("sauceAccessKey")+"@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
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
	
	
	private void loadProperties() throws IOException{
		prop.load(new FileInputStream("resources/conf.properties"));
	}
	
	private String getProperty(String property){
		return prop.getProperty(property);
	}
}
