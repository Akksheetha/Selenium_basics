package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebElementActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		WebElement blog = driver.findElement(By.id("blogsmenu"));
		Actions action = new Actions(driver);
		action.moveToElement(blog).perform();
		WebElement option = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]"));
		action.moveToElement(option).click().build().perform();

	}

}
