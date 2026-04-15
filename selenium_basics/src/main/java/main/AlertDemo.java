package main;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		WebElement e = driver.findElement(By.id("alert1"));
		e.click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Alert 1 : "+alert1.getText());
		Thread.sleep(3000);
		alert1.accept();
		WebElement e2 = driver.findElement(By.id("prompt"));
		e2.click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert2.sendKeys("ABC");
		System.out.println("Alert 2 : "+alert2.getText());
		Thread.sleep(2000);
		alert2.accept();
		WebElement e3 = driver.findElement(By.id("confirm"));
		e3.click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println("Alert 3 : "+alert3.getText());
		Thread.sleep(3000);
		alert3.accept();

	}

}
