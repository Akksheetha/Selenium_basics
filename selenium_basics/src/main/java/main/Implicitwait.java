package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Implicitwait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement dropdown = driver.findElement(By.className("dropbtn"));
        dropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dropdown1 = driver.findElement(By.linkText("Facebook"));
        dropdown1.click();
        System.out.println("done");
    }
}