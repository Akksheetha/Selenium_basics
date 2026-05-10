package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioOutlineDefinitions {
	
	WebDriver driver;
	WebDriverWait wait;
	@Given("the user is on Login page")
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
		driver.findElement(By.id("login2")).click();
	}
	
	@When("user enters UserName as {string}")
	public void usernameType(String username) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys(username);
	}
	
	@And("user enters Password as {string}")
	public void passwordType(String password) {
		driver.findElement(By.id("loginpassword")).sendKeys(password);
	}
	
	@And("user clicks the login button")
	public void loginclick() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	
	@Then("popup {string} should be displayed successfully")
	public void message(String expectedMessage) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.alertIsPresent());
	    String actualMessage = driver.switchTo().alert().getText();
	    System.out.println("Expected: " + expectedMessage);
	    System.out.println("Actual: " + actualMessage);
	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim());
	    driver.switchTo().alert().accept();
	    driver.quit();
	}

}
