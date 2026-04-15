package main;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class KeyDownActions{
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://omayo.blogspot.com/");
	Actions action=new Actions(driver);
	WebElement compendiumDevlink=driver.findElement(By.linkText("compendiumdev"));
	action.keyDown(Keys.CONTROL).moveToElement(compendiumDevlink).click().keyUp(Keys.CONTROL).build().perform();
	String parentWindowhandle=driver.getWindowHandle();
	Set<String>windowhandles=driver.getWindowHandles();
	for(String handles:windowhandles)
	{
		driver.switchTo().window(handles);
	}
	Thread.sleep(3000);
	System.out.println("Child Window"+windowhandles);
	driver.switchTo().window(parentWindowhandle);
}
}