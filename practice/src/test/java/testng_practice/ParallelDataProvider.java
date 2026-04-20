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
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	    WebElement txtBox = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.id("sb_form_q"))
	    );
	    txtBox.sendKeys(keyWord);
	    txtBox.sendKeys(Keys.ENTER);
	    Assert.assertTrue(true);
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
	  driver1.quit();  
	  driver.remove();
	  }
  }

}
