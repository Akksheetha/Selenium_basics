package testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class ParameterizationDemo {

    WebDriver driver;

    @Test
    @Parameters({"username","password"})
    public void validCredentials(String name, String password) {
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(name);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
    }
    
    @Test(enabled=false)
    @Parameters({"invalidusername","invalidpassword"})
    public void invalidCredentials(String invalidname, String invalidpassword) {
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(invalidname);
        driver.findElement(By.id("loginpassword")).sendKeys(invalidpassword);
    }
    
    @Test(enabled=false)
    @Parameters({"invalidusername1","invalidpassword1"})
    public void invalidCredentials1(String invalidname, String invalidpassword) {
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(invalidname);
        driver.findElement(By.id("loginpassword")).sendKeys(invalidpassword);
    }

    @BeforeMethod
    @Parameters({"browser","url"})
    public void beforeMethod(String browser, String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); 
        driver = new ChromeDriver(options);
        System.out.println("Browser Started : " + browser);
        driver.get(url);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); 
    }
}