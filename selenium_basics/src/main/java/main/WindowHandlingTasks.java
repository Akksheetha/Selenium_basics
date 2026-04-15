package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class WindowHandlingTasks {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml;jsessionid=node09ulkc7xnwwla5xqy36dpx7p814530899.node0");
		String parent = driver.getWindowHandle();
		System.out.println("Parent : "+parent);
//		driver.findElement(By.id("j_idt88:new")).click();
//		String newTab = driver.getWindowHandle();
//		if(parent!=newTab) {
//			System.out.println("New Tab opened");
//		}
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Size : "+allWindowHandles.size());
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		Set<String> newWindow =  driver.getWindowHandles(); 
		System.out.println("New Size : "+newWindow.size());
		for(String id : newWindow) {
			if(id!=parent) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		
	}
}
