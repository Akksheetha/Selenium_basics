package StepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

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

public class MultipleRowsDataTableDefinitions {
	
	WebDriver driver;
	WebDriverWait wait;
	@Given("he user is on demoblaze1 Login page")
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
		driver.findElement(By.id("login2")).click();
	}
	
	@When("user enters invalid credentials with multiple")
	public void usernameType(DataTable usertable) throws InterruptedException {
        Thread.sleep(2000);
        List<Map<String, String>> user = usertable.asMaps(String.class,String.class);
        for(Map<String, String> form : user) {
        	String username = form.get("Username");
        	System.out.println("Username : "+username);
        	driver.findElement(By.name("username")).sendKeys(username);
        	String password = form.get("Password");
        	System.out.println("Password");
        	driver.findElement(By.name("password")).sendKeys(password);
        	driver.findElement(By.xpath(""));
        }
        
	}
	
	@And("user clicks the login button in demoblaze1 site")
	public void loginclick() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	
	@Then("user should be able to login successfully in deomblaze site1")
	public void message() throws InterruptedException {
		Thread.sleep(5000);
		String text = driver.findElement(By.id("nameofuser")).getText();
		Assert.assertEquals(text, "Welcome Admin");
	    driver.quit();
	}

}
