package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class omayo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement dropdown = driver.findElement(By.cssSelector("button#myDropdown"));
        dropdown.click();
        Thread.sleep(5000);
        WebElement dropdown1 = driver.findElement(By.linkText("Facebook"));
        dropdown1.click();
        System.out.println("done");
    }
}