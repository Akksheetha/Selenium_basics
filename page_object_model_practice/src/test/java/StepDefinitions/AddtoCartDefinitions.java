package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

public class AddtoCartDefinitions {
	
	WebDriver driver;
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
	}

}
