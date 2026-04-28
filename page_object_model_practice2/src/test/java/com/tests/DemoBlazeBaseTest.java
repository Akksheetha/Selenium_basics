package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DemoBlazeBaseTest {
	public WebDriver driver;
	@BeforeClass
	public void setup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoblaze.com/");
	}
	@AfterClass
	public void close() {
		driver.quit();
	}

}
