package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class clickable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement timerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("timerButton")));
        timerButton.click();
        
        WebElement another = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert2")));
        another.click();
        driver.close();
    }
}