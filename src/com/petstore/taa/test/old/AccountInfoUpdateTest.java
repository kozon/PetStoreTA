package com.petstore.taa.test.old;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AccountInfoUpdateTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAccountInfoUpdate() throws Exception {
    driver.get(baseUrl + "/applicationPetstore/main.xhtml");
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.id("j_idt67:login")).clear();
    driver.findElement(By.id("j_idt67:login")).sendKeys("user");
    driver.findElement(By.id("j_idt67:password")).clear();
    driver.findElement(By.id("j_idt67:password")).sendKeys("user");
    driver.findElement(By.name("j_idt67:j_idt72")).click();
    driver.findElement(By.linkText("Welcome Michal")).click();
    driver.findElement(By.linkText("Edit Your Account Information")).click();
    driver.findElement(By.id("j_idt66:firstname")).clear();
    driver.findElement(By.id("j_idt66:firstname")).sendKeys("Michal");
    driver.findElement(By.name("j_idt66:j_idt97")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Your account has been updated".equals(driver.findElement(By.cssSelector("li.alert.alert-info")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.linkText("Log out")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Youve been logged out".equals(driver.findElement(By.cssSelector("li.alert.alert-info")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
