package testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo {
	WebDriver driver;
	
  @Test(dataProvider="testData1", dataProviderClass=DataProviderClass.class)
  public void check(String keyWord) {
	  WebElement txtBox = driver.findElement(By.id("sb_form_q"));
	  txtBox.sendKeys(keyWord);
	  System.out.println("Key word entered is : "+keyWord);
	  txtBox.submit();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.urlContains("search"));
	  String currentUrl = driver.getCurrentUrl();
	  Assert.assertTrue(currentUrl.toLowerCase().contains(keyWord.toLowerCase()),
	      "Search keyword not present in URL");
	    System.out.println("Search result is displayed");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before the test");
	  driver = new ChromeDriver();
	  driver.get("https://www.bing.com");
//	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("End of the test");
  }

}
