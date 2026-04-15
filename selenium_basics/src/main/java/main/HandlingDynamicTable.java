package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		WebElement e = driver.findElement(By.id("email"));
		e.click();
		e.sendKeys("2k22csbs03@kiot.ac.in",Keys.ENTER);
		WebElement e2 = driver.findElement(By.id("password"));
		e2.click();
		e2.sendKeys("Password@1234",Keys.ENTER);
		driver.findElement(By.id("submit"));
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"myTable\"]"));
		for(WebElement list: rows) {
			System.out.print(list.getText()+" ");
		}
		driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");
		List<WebElement> contactNames = driver.findElements(By.xpath("//table[@id='myTable']/tr/td[2]"));
		int contactCount = contactNames.size();
		System.out.println("Total contact count:"+contactCount);
		for(WebElement name : contactNames) {
			System.out.println(name.getText());
		}
		int i = 1;
		for(WebElement name : contactNames) {
			String expectedName = name.getText();
			if(name.getText().equals(expectedName)) {
				List<WebElement> actualRowData = driver.findElements(By.xpath("//table[@id='myTable']/tr["+i+"]"));
				for(WebElement row:actualRowData) {
					System.out.println(row.getText());
				}
			}
			i++;
		}
		System.out.println("Done");
		
	}

}
