package main;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class demo {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.flipkart.com");
		try {
			driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		} catch (Exception e) {
			System.out.println("Popup not displayed");
		}
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Flipkart", Keys.ENTER);
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		System.out.println("Title length: " + title.length());
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currenturl);
		System.out.println("Page source length: " + driver.getPageSource().length());

		driver.quit();
	}
}