package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeafGround {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.navigate().to("https://www.leafground.com/waits.xhtml;jsessionid=node016axxgzztbtm8ia3ifg92asf714507702.node0");
		WebElement e = driver.findElement(By.id("j_idt87:j_idt89"));
		e.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt87:j_idt90"))); 
		element.click();
		WebElement e1 = driver.findElement(By.id("j_idt87:j_idt92"));
		e1.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt87:j_idt93")));
		WebElement e2 = driver.findElement(By.id("j_idt87:j_idt95"));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt87:j_idt95")));
		e2.click();
		WebElement e21 = driver.findElement(By.id("j_idt87:j_idt96"));
		e21.click();
		WebElement e3 = driver.findElement(By.id("j_idt87:j_idt98"));
		e3.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt87:j_idt99")));
		System.out.println("Done");
	}

}
