package autoitworks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class pdfdoc {
	public static void main(String args[]) throws IOException, AWTException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://pdf2doc.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		driver.findElement(By.xpath("//label[@id = \"uploadBtn\"]")).click();
		Thread.sleep(3000);	
		Robot robot = new Robot();	
		StringSelection str = new StringSelection("file:C:\\Users\\akksh\\OneDrive\\Desktop\\sample.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);	
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);	
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		String downloadCount = driver.findElement(By.xpath("//span[@id = \"downloadCounter\"]")).getText();
		if(downloadCount.equals("1"))
		{
			System.out.println("File uploaded");
		}
		else
		{
			System.out.println("File not uploaded");
		}
		
	}
}