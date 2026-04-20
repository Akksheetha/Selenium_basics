package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeWorking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Login
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoblaze.com");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(By.id("login2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
		WebElement name = driver.findElement(By.id("loginusername"));
		name.click();
		name.sendKeys("Admin");
		WebElement pass = driver.findElement(By.id("loginpassword"));
		pass.click();
		pass.sendKeys("admin");
		driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		String text = driver.findElement(By.id("nameofuser")).getText();
		if(text.contains("Welcome")) {
			System.out.println("login successful");
		}
		
		
		//Category Navigation & Product Handling
		driver.findElement(By.xpath("//a[contains(@class,'list-group-item') and text()='Laptops']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
		Thread.sleep(5000);
		List<WebElement> product = driver.findElements(By.className("hrefch"));
		List<String> productList = new ArrayList<>();
		for(WebElement p : product) {
			productList.add(p.getText());
		}
		Collections.sort(productList);
		Set<String> uniqueproducts = new LinkedHashSet<>(productList);
		for(String p : uniqueproducts) {
			System.out.println("Found Laptop : "+p);
		}
		Actions act = new Actions(driver);
		WebElement lap = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", lap);
		if(lap.getText().contains("Pro")) {
			System.out.println("MacBook Pro Found");
		}
		act.moveToElement(lap).click().perform();
		
		
		
		//Add Product to Cart9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']")));
		String title = driver.findElement(By.xpath("//h2[text()='MacBook Pro']")).getText();
		if(title.contains("MacBook Pro")) {
			System.out.println("Navigated to MacBook pro page");
		}
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		//handling alert
		driver.switchTo().alert().accept();
		System.out.println("Alert handled successfully");
		System.out.println("Mac Book added to cart");
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		
		
		
		//Place Order
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModalLabel")));
		driver.findElement(By.id("name")).sendKeys("ABCD");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Namakkal");
		driver.findElement(By.id("card")).sendKeys("123456789");
		driver.findElement(By.id("month")).sendKeys("4");
		driver.findElement(By.id("year")).sendKeys("2026");
		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'sa-success')]")));
		String check = driver.findElement(By.cssSelector(".lead.text-muted")).getText();
		if (check.contains("Id")) { 
		    System.out.println("Order is placed successfully"); 
		    System.out.println(check);
		} else { 
		    System.out.println("Order is Unsuccessful"); 
		} 
		System.out.println("Done");
		driver.quit();
	
	}

}

