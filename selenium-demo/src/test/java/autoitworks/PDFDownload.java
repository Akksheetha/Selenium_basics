package autoitworks;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PDFDownload {
	public static void main(String[] args) throws InterruptedException {
		String downloadFilepath = System.getProperty("user.dir")+File.separator+"downloads";
	    ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("download.default_directory", downloadFilepath);
	    options.setExperimentalOption("prefs", prefs);
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://demoqa.com/upload-download");
	    WebElement downloadlink = driver.findElement(By.id("downloadButton"));
	    downloadlink.click();
	    Thread.sleep(5000);
	    File downloadFile = new File(downloadFilepath+"Free_Test_Data_100kb_PDF.pdf");
	    if(downloadFile.exists()) {
	    	System.out.println("File is downloaded!");
	    }
	    else {
	    	System.out.println("File is not downloaded");
	    }
	    driver.quit();
	}

}
