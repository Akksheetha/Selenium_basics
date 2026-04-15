package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		Actions action = new Actions(driver);
		WebElement e1 = driver.findElement(By.id("form:drag"));
		WebElement e2 = driver.findElement(By.id("form:drop"));
		action.dragAndDrop(e1,e2).perform();
	}

}
