package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchfieldinWebElementActions {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
//		WebElement blogs = driver.findElement(By.id("blogsmenu"));
		Actions action = new Actions(driver);
//		WebElement searchfield = driver.findElement(By.xpath("//input[@name='q']"));
//		action.contextClick(searchfield);
		WebElement e = driver.findElement(By.id("myBtn"));
	    action.doubleClick(e).perform();
	}
}
