package demo;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		String parent = driver.getWindowHandle();
		driver.findElement(By.id("tabButton")).click();
		Set<String> window = driver.getWindowHandles();
		System.out.println(window.size());
		for(String i : window) {
			if(!i.equals(parent)) {
			driver.switchTo().window(i);
			driver.close();		
			}
		}
		driver.switchTo().window(parent);
		driver.close();
		System.out.println("Done");
	}

}
