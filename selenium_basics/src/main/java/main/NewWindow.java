package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class NewWindow {
	
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
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.bing.com/?toWww=1&redig=C913CC2008904EE98B1890CAFD3DE2D3");
	    System.out.println("Current URL is "+driver.getCurrentUrl());
	    driver.close();
		
		
	}
}
