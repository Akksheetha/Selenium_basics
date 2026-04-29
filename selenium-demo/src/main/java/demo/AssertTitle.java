package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssertTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Selenium", Keys.ENTER);;
		String at = driver.getTitle();
		if(at.contains("Google")) {
			System.out.println("Page directed successfully");
		}
		else {
			System.out.println("Some error occured");
		}
		driver.close();

	}

}
