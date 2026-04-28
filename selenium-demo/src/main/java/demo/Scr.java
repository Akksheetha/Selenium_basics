package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scr {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		TakesScreenshot st = (TakesScreenshot) driver;
		File f = st.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f,new File("img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot captured");
	}

}
