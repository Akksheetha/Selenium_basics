package main;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class demo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

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
		System.out.println("Page title is " + title);
		System.out.println(title.length());

		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL Command is " + currenturl);

		System.out.println("Page source length is " + driver.getPageSource().length());

		driver.quit();
	}
}