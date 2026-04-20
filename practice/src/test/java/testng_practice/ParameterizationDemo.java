package testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class ParameterizationDemo {

    WebDriver driver;

    @Test
    @Parameters({"username","password"})
    public void validCredentials(String name, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys(name);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        Assert.assertTrue(driver.findElement(By.id("loginusername")).isDisplayed());
        System.out.println("Login test executed");
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