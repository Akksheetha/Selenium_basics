package testng_practice;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(testng_practice.ListenerPractice.class)
public class TutorialsNinjaLoggingandListener {
	private static Logger logger = LogManager.getLogger(TutorialsNinjaLoggingandListener.class);
	public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
  @Test(dataProvider="tutorialsninjadata", dataProviderClass=com.utils.TutorialsNinjaData.class)
  public void validLoginTest(String email, String password,String type) {
	  if(!type.equals("valid")) {
		  logger.debug("Skipping Invalid data to execute only valid data");
		  throw new SkipException("Skipping invalid data");
	  }
	  WebDriver driver1 = driver.get();
	  driver1.get("https://tutorialsninja.com/demo/");
	  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	  driver1.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	  driver1.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("input-email")));
	  driver1.findElement(By.id("input-email")).sendKeys(email);
	  driver1.findElement(By.id("input-password")).sendKeys(password);
	  driver1.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > h2:nth-child(1)")));
	  String actual = driver1.findElement(By.cssSelector("#content > h2:nth-child(1)")).getText();
	  Assert.assertTrue(actual.contains("My Account"));
	  logger.info("Valid login test done");
  }
  @Test(dataProvider="tutorialsninjadata", dataProviderClass=com.utils.TutorialsNinjaData.class)
  public void invalidLoginTest(String email, String password,String type) {
	  if(!type.equals("invalid")) {
		  logger.debug("Skipping valid data to execute only Invalid data");
		  throw new SkipException("Skipping valid data");
	  }
	  WebDriver driver1 = driver.get();
	  driver1.get("https://tutorialsninja.com/demo/");
	  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	  driver1.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	  driver1.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("input-email")));
	  driver1.findElement(By.id("input-email")).sendKeys(email);
	  driver1.findElement(By.id("input-password")).sendKeys(password);
	  driver1.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")));
	  String actual = driver1.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();
	  Assert.assertTrue(actual.contains("Warning"));
	  logger.info("InValid login test done");
	  
  }
  @Test(dataProvider="searchData", dataProviderClass = com.utils.TutorialsNinjaData.class, dependsOnMethods = "validLoginTest")
  public void searchProduct(String word) {
	  
	  WebDriver driver1 = driver.get();
	  driver1.get("https://tutorialsninja.com/demo/");
	  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	  driver1.findElement(By.cssSelector("#search > input")).sendKeys(word,Keys.ENTER);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > h2")));
	  String text = driver1.getCurrentUrl();
	  Assert.assertTrue(text.contains("search"));
	  logger.info("Searching a product done");
  }
  @BeforeMethod
  public void BeforeMethod() {
	  logger.info("Opening the Tutorials Ninja Website");
	  driver.set(new ChromeDriver());
  }
  @AfterMethod
  public void AfterMethod() {
	  WebDriver driver1 = driver.get();
	  logger.info("Closing the Tutorials Ninja Website");
	  driver1.close();
	  driver.remove();
  }
}
