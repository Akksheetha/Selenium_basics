package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		List<WebElement> headings = driver.findElements(By.xpath("//table[@id='table1']"));
		System.out.println(headings.size());
		System.out.print("All values : ");
		for(WebElement heading : headings) {
			System.out.print(heading.getText()+" ");
		}
		List<WebElement> headings1 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
		System.out.println(headings1.size());
		System.out.print("First Row : ");
		for(WebElement heading : headings1) {
			System.out.print(heading.getText()+" ");
		}
		List<WebElement> headings3 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]//td[3]"));
		System.out.println(headings3.size());
		System.out.print("First Row First Index Value : ");
		for(WebElement heading : headings3) {
			System.out.print(heading.getText()+" ");
		}
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
		int rowsCount = rows.size();
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']//th"));
		int columnsCount = columns.size();
		for(int r = 1;r<rowsCount;r++) {
			for(int c = 1;c<columnsCount;c++) {
			WebElement data;
			if(r==1) {
				data = driver.findElement(By.xpath("//table[@id='table1']//tr["+r+"]//th["+c+"]"));
			}
		}

	}

	}
}
