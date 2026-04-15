package main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedInTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/login");
        WebElement username = driver.findElement(By.cssSelector("input#username"));
        username.sendKeys("akkshee@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("input#password"));
        password.sendKeys("jimsat19");
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        String url = driver.getCurrentUrl();      
        if(url.equals("https://www.linkedin.com/feed/")) {
        	System.out.println("Login successful");
        }
        else {
        	System.out.println("Login failed");
        }
    }
}