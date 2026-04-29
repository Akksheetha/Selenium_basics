package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elementscr {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"nava\"]/img"));
		File src = ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("logo.png"));

	}

}
