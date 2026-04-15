package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locate {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement element = driver.findElement(By.id("reveal"));
		element .click();
		WebElement search = driver.findElement(By.id("revealed"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement timerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("timerButton")));
		search.sendKeys("ABCD", Keys.ENTER);
		WebElement input = driver.findElement(By.id("revealed"));
		String text = input.getAttribute("revelaed");
		System.out.println("text: "+text);
	}
}
