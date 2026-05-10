package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TutorialsNinjaLoginDefinition {
	
	WebDriver driver;
	WebDriverWait wait;
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@Given("the user is on Login page of Tutorials Ninja")
	public void login() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='My Account']")));
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	@When("the user enters the {string} and {string}")
    public void credentials(String email, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));		
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(pass);
	}
	
	@And("clicks the login button in the site")
	public void loginclick() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	}
    
	@Then("the user should be redirected to home page")
	public void homepage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
		String text = driver.findElement(By.linkText("My Account")).getText();
		Assert.assertEquals(text, "My Account");
		driver.quit();
	}
}
