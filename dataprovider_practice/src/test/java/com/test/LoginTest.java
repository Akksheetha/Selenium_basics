package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
  @Test(dataProvider="validexcelData", dataProviderClass=com.utils.DPExcel.class)
  public void login(String username, String password, String testType) {
	  WebDriver driver1 = driver.get();
      driver1.get("https://demoblaze.com/");

      WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
      JavascriptExecutor js = (JavascriptExecutor) driver1;
      js.executeScript("arguments[0].click();", driver1.findElement(By.id("login2")));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
      driver1.findElement(By.id("loginusername")).sendKeys(username);
      driver1.findElement(By.id("loginpassword")).sendKeys(password);
      Assert.assertTrue(driver1.findElement(By.id("loginpassword")).isDisplayed());
      driver1.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
      System.out.println("Login test executed for: " + username);
      if (testType.equalsIgnoreCase("valid")) {
          String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))).getText();
          String expectedText = "Welcome Admin";
          System.out.println("Actual Welcome Text: " + actualText);
          Assert.assertEquals(actualText, expectedText,"Valid login is failed");
      }
      else if (testType.equalsIgnoreCase("invalidUserName")) {
          Alert alert = wait.until(ExpectedConditions.alertIsPresent());
          String actualAlert = alert.getText();
          String expectedAlert = "User does not exist.";
          System.out.println("Alert Message: " + actualAlert);
          Assert.assertEquals(actualAlert, expectedAlert,"Invalid username alert mismatch");
          alert.accept();
      }
      else if (testType.equalsIgnoreCase("invalidPassword")) {
          Alert alert = wait.until(ExpectedConditions.alertIsPresent());
          String actualAlert = alert.getText();
          String expectedAlert = "Wrong password.";
          System.out.println("Alert Message: " + actualAlert);
          Assert.assertEquals(actualAlert, expectedAlert,"Invalid password alert mismatch");
          alert.accept();
      }
  }
  
  @BeforeMethod
  public void beforeMethod() {
      driver.set(new ChromeDriver());
      System.out.println("Starting test");
  }
  @AfterMethod
  public void afterMethod() {
      WebDriver driver1 = driver.get();
      if (driver1 != null) {
          driver1.quit();  
      }
  }
}
