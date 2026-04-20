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

public class ParallelDataProvider {
	private static final ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();
  @Test(dataProvider="testData", dataProviderClass=DataProviderClass.class)
  public void check(String keyWord) {
	  WebDriver driver1 = driver.get();
	  driver1.get("https://www.bing.com");
	  WebElement txtBox = driver1.findElement(By.id("sb_form_q"));
	  txtBox.sendKeys(keyWord);
	  System.out.println("Key word entered is : "+keyWord);
	  txtBox.sendKeys(Keys.ENTER);
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
