package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptInsights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		WebElement name = driver.findElement(By.xpath("//*[@id=\"post-body-299858861183690484\"]/div/form/div[1]/input[1]"));
		name.click();
		name.sendKeys("Akkshee",Keys.ENTER);
		WebElement lname = driver.findElement(By.xpath("//*[@id=\"post-body-299858861183690484\"]/div/form/div[1]/input[2]"));
		lname.click();
		lname.sendKeys("M",Keys.ENTER);
		WebElement mail = driver.findElement(By.xpath("//*[@id=\"post-body-299858861183690484\"]/div/form/div[1]/input[3]"));
		mail.click();
		mail.sendKeys("abc@gmail.com",Keys.ENTER);
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"post-body-299858861183690484\"]/div/form/div[1]/div[2]/input"));
		pass.click();
		pass.sendKeys("12345",Keys.ENTER);
		WebElement repeat = driver.findElement(By.xpath("//*[@id=\"post-body-299858861183690484\"]/div/form/div[1]/input[4]"));
		repeat.click();
		repeat.sendKeys("12345",Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String domain = js.executeScript("return document.domain").toString();
		System.out.println("Domain name is "+domain);
		String url = js.executeScript("return document.URL").toString();
		System.out.println("Page URL is "+url);
		String title = js.executeScript("return document.title").toString();
		System.out.println("Page title is "+title);
		js.executeScript("window.history.go(0)");
		js.executeScript("window.scrollBy(0,500)");
		System.out.println("Done");

	}

}
