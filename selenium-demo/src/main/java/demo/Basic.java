package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("Flipkart");
//		System.out.println("The title is "+driver.getTitle());
//		System.out.println("The current url is "+driver.getCurrentUrl());
////		System.out.println("The Page source is "+driver.getPageSource());
//		driver.navigate().to("https://flipkart.com");
//		driver.close();
	}
}
