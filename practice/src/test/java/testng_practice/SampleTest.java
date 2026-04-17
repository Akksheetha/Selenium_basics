package testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class SampleTest {
	public WebDriver driver;
  @Test
  public void loginCheck() {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.id("loginusername")).sendKeys("Admin");
	  driver.findElement(By.id("loginpassword")).sendKeys("admin");
	  driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--start-maximized");
//	  options.addArguments("--headless");
	  driver = new ChromeDriver(options);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://demoblaze.com/");
  }

  @AfterTest
  public void afterTest() {
  }

}
