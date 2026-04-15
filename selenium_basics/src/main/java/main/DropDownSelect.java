package main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml;jsessionid=node01slmssqng58d9raho3ytl79me14556592.node0");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement uiautomation = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select dropdown = new Select(uiautomation);
		List<WebElement> list1 = dropdown.getOptions();
		System.out.println("The Dropdown option size:"+list1.size());
		for(WebElement ls : list1) {
			System.out.println("The dropdown options are:"+ls.getText());
		}
		Boolean multiple = dropdown.isMultiple();
		System.out.println("The multiple options available: "+multiple);
		dropdown.selectByIndex(1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dropdown.selectByVisibleText("Puppeteer");
		

	}

}
