package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		WebElement iframeElement = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframeElement);
		String frame_1 = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Switch by locator : "+frame_1);
		driver.switchTo().defaultContent();
		String mainPage = driver.findElement(By.xpath("//*[@id='framesWrapper']")).getText();
		System.out.println("Back to main page : "+mainPage);
		driver.switchTo().frame(1);
//		String Frame_2 = driver.findElement(By.)
		
	}

}
