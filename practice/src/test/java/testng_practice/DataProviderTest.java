package testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataProviderTest {
	
	private static final ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();
	
  @Test(dataProvider = "Demo", dataProviderClass=DataProviderClass.class)
  public void login(String user,String pass) {
	  WebDriver driver1 = driver.get();
	  driver1.get("https://demoblaze.com/");
	  driver1.findElement(By.id("login2")).click();
	  driver1.findElement(By.id("loginusername")).sendKeys(user);
	  driver1.findElement(By.id("loginpassword")).sendKeys(pass);
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
	  }
  }

}
