package testng_practice;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.annotations.Listeners;

@Listeners(testng_practice.ListenerPractice.class)
public class ListenerImplementationOriginal {
	private static Logger logger = LogManager.getLogger(ListenerImplementationOriginal.class);
	WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
  	  logger.info("Starting the test");
  	  ChromeOptions options=new ChromeOptions();
  	  driver=new ChromeDriver(options);
  	  options.addArguments("--start-maximize");
  	  driver.get("https://demoblaze.com/");
  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  	  logger.info("DemoBlaze Website opened");
    }
    
    @Test(priority = 2)
    public void validation() {
  	  driver.findElement(By.id("login2")).click();
  	  driver.findElement(By.id("loginusername")).sendKeys("Admin");
  	  driver.findElement(By.id("loginpassword")).sendKeys("admin");
      driver.findElement(By.xpath("//button[text()='Log in']")).click();
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      String actualUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))).getText();
      logger.info("Login successful with valid credentials");
      logger.debug("Logged in with username=Admin and password=admin");
    }
    
    
    @Test(priority = 1)
    public void invaliduser() {
    	driver.findElement(By.id("login2")).click();
	  	driver.findElement(By.id("loginusername")).sendKeys("Admin");
	  	driver.findElement(By.id("loginpassword")).sendKeys("admin!");
	    driver.findElement(By.xpath("//button[text()='Log in']")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        String msg = alert.getText();
	        System.out.println(msg);
	        logger.info("Trying to login with invalid password");
	        logger.warn("Alert for invalid password popped");
	        alert.accept();
	        logger.info("Alert accepted");

	    } catch (Exception e) {
	        String user = driver.findElement(By.id("nameofuser")).getText();
	        logger.error("Logged in failed as "+user);
	    }
    }
    

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
