package testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DataProviderTest {
	
	private static final ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();
	
	@Test(dataProvider = "Demo", dataProviderClass = DataProviderClass.class)
	public void login(String user, String pass) {

	    WebDriver driver1 = driver.get();
	    driver1.get("https://demoblaze.com/");
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
	        .sendKeys(user);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")))
	        .sendKeys(pass);
	    driver1.findElement(By.xpath("//button[text()='Log in']")).click();
	    Assert.assertTrue(true);
	}
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Starting of the test");
	  driver.set(new ChromeDriver());
	  driver.get();
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Ending the test");
	  WebDriver driver1 = driver.get();
	  if(driver1!=null) {
	  System.out.println("End of the test");
	  driver1.quit();  
	  driver.remove();
	  }
  }

}
