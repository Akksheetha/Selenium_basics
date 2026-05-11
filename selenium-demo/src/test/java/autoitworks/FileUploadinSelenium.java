package autoitworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUploadinSelenium {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		WebElement upload = driver.findElement(By.id("uploadFile"));
		upload.sendKeys("C:\\Users\\akksh\\OneDrive\\Desktop\\sample.pdf");
		String message = driver.findElement(By.id("uploadedFilePath")).getText();
		System.out.println("Message is : "+message);
		driver.close();
	}
}
