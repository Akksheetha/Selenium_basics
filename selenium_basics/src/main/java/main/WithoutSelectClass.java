package main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WithoutSelectClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml;jsessionid=node01slmssqng58d9raho3ytl79me14556592.node0");
		WebElement e = driver.findElement(By.id("j_idt87:country_label"));
		e.click();
//		Thread.sleep(5000);
		WebElement e1 = driver.findElement(By.id("j_idt87:country_3"));
		e1.click();
		WebElement searchBox = driver.findElement(By.id("j_idt87:auto-complete_input"));
		searchBox.sendKeys("selenium",Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		searchBox.click();
		List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul/li")));
		for(WebElement option : suggestions) {
			if(option.getText().equals("AWS")) {
				option.click();
			}
		}
	}

}
