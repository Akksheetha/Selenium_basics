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

public class ParallelDataProvider {
	private static final ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();
  @Test(dataProvider="testData", dataProviderClass=DataProviderClass.class)
  public void check(String keyWord) {
	  WebDriver driver1 = driver.get();
	  driver1.get("https://www.bing.com");
	  WebElement txtBox = driver1.findElement(By.id("sb_form_q"));
	  txtBox.sendKeys(keyWord);
	  System.out.println("Key word entered is : "+keyWord);
	  txtBox.submit();
	  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.urlContains("search"));
	  String currentUrl = driver1.getCurrentUrl();
	  Assert.assertTrue(currentUrl.toLowerCase().contains(keyWord.toLowerCase()),
	      "Search keyword not present in URL");
	    System.out.println("Search result is displayed");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Start the test");
	  driver.set(new ChromeDriver());
  }

  @AfterMethod
  public void afterMethod() {
	  WebDriver driver1 = driver.get();
	  if(driver1!=null) {
	  System.out.println("End of the test");
	  }
  }

}
