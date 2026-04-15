package main;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String  parenthandle = driver.getWindowHandle();
		System.out.println(parenthandle);
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Count of window:"+allWindowHandles.size());
		driver.findElement(By.id("windowButton")).click();
		Set<String> newallWindowHandles = driver.getWindowHandles();
		System.out.println("New Count of window:"+newallWindowHandles.size());
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle : "+parentHandle);
		Iterator<String> iterator = newallWindowHandles.iterator();
		String mainWindow = iterator.next();
		String childWindow = iterator.next();
		System.out.println("Main Window is "+mainWindow);
		System.out.println("Child Window is "+childWindow);
		driver.switchTo().window(childWindow);
		WebElement text = driver.findElement(By.id("sampleHeading"));
		System.out.println("Child_Title : "+text.getText());
		driver.close();
		driver.switchTo().window(parenthandle);
		System.out.println("Parent Title : "+driver.getTitle());
		driver.quit();
		
		
		
	}

}
