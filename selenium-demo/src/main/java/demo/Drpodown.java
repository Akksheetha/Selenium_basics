package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drpodown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml;jsessionid=node0iml4rwdgent21v4f8log7i9pn14542478.node0");
		WebElement drop = driver.findElement(null);
		

	}

}
