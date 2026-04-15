package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demoblaze.com/");
		driver.findElement(By.id("login2")).click();
		WebElement element = driver.findElement(By.id("loginusername"));
		element.click();
		element.sendKeys("admin",Keys.ENTER);
		WebElement element2 = driver.findElement(By.id("loginpassword"));
		element2.click();
		element2.sendKeys("admin",Keys.ENTER);
		driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		driver.findElement(By.id("nameofuser"));
		System.out.println("Done");
	}
}
