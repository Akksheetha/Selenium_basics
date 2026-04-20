package testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo {
	WebDriver driver;
	
  @Test(dataProvider="testData", dataProviderClass=DataProviderClass.class)
  public void check(String keyWord) {
	  WebElement txtBox = driver.findElement(By.id("sb_form_q"));
	  txtBox.sendKeys(keyWord);
	  System.out.println("Key word entered is : "+keyWord);
	  txtBox.sendKeys(Keys.ENTER);
	  System.out.println("Search result is displayed");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before the test");
	  driver = new ChromeDriver();
	  driver.get("https://www.bing.com");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("End of the test");
  }

}
