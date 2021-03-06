package com.petstore.taa.test.old;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CartUpdateTest {
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
  public void testCartUpdate() throws Exception {
    driver.get(baseUrl + "/applicationPetstore/main.xhtml");
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.id("j_idt67:login")).clear();
    driver.findElement(By.id("j_idt67:login")).sendKeys("user");
    driver.findElement(By.id("j_idt67:password")).clear();
    driver.findElement(By.id("j_idt67:password")).sendKeys("user");
    driver.findElement(By.name("j_idt67:j_idt72")).click();
    driver.findElement(By.linkText("Fish")).click();
    driver.findElement(By.linkText("Goldfish")).click();
    driver.findElement(By.linkText("Add to Cart")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Total $ 12.0   Check Out".equals(driver.findElement(By.cssSelector("#j_idt68 > div")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.linkText("Fish")).click();
    driver.findElement(By.linkText("Goldfish")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Add to Cart')])[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Total $ 24.0   Check Out".equals(driver.findElement(By.cssSelector("#j_idt68 > div")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("j_idt68:j_idt69:0:j_idt81")).clear();
    driver.findElement(By.name("j_idt68:j_idt69:0:j_idt81")).sendKeys("2");
    driver.findElement(By.linkText("Update")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Total $ 36.0   Check Out".equals(driver.findElement(By.cssSelector("#j_idt68 > div")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("j_idt68:j_idt69:1:j_idt81")).clear();
    driver.findElement(By.name("j_idt68:j_idt69:1:j_idt81")).sendKeys("2");
    driver.findElement(By.xpath("(//a[contains(text(),'Update')])[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Total $ 48.0   Check Out".equals(driver.findElement(By.cssSelector("#j_idt68 > div")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.linkText("Fish")).click();
    driver.findElement(By.linkText("Koi")).click();
    driver.findElement(By.linkText("Add to Cart")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Total $ 60.0   Check Out".equals(driver.findElement(By.cssSelector("#j_idt68 > div")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("(//a[contains(text(),'Remove')])[3]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Total $ 48.0   Check Out".equals(driver.findElement(By.cssSelector("#j_idt68 > div")).getText())) break; } catch (Exception e) {}
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
