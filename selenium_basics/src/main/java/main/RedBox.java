package main;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement box = driver.findElement(By.id("adder"));
        box.click();
        WebElement redBox = driver.findElement(By.id("box0"));
        String style = redBox.getAttribute("style");
        String classname = redBox.getAttribute("class");
        System.out.println("style: "+style);
        System.out.println("class: " + classname);
    }
}