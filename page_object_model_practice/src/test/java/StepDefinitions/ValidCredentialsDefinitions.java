package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidCredentialsDefinitions {
	
	WebDriver driver;
	WebDriverWait wait;
	@Given("the user is on demoblaze Login page")
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
		driver.findElement(By.id("login2")).click();
	}
	
	@When("user enters valid credentials")
	public void usernameType(DataTable datatable) throws InterruptedException {
        Thread.sleep(2000);
        List<List<String>> signup = datatable.asLists(String.class);
        String username = signup.get(0).get(0);
        String password = signup.get(0).get(1);
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
	}
	
	@And("user clicks the login button in demoblaze site")
	public void loginclick() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	
	@Then("user should be able to login successfully in deomblaze site")
	public void message() throws InterruptedException {
		Thread.sleep(5000);
		String text = driver.findElement(By.id("nameofuser")).getText();
		Assert.assertEquals(text, "Welcome Admin");
	    driver.quit();
	}

}
