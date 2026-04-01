package main;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.co.in");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Flipkart",Keys.ENTER);
		String title = driver.getTitle();
		System.out.println("Page title is "+ title);
		System.out.println(title.length());
		String  currenturl = driver.getCurrentUrl();
		System.out.println("Current URL Command is "+currenturl);
		String pagesource = driver.getPageSource();
		System.out.println("Page sorce command is "+pagesource);
		driver.close();
	}

}
