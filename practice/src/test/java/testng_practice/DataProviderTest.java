package testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class DataProviderTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @Test(dataProvider = "Demo", dataProviderClass = DataProviderClass.class)
    public void login(String user, String pass) {

        WebDriver driver1 = driver.get();
        driver1.get("https://demoblaze.com/");

        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
        JavascriptExecutor js = (JavascriptExecutor) driver1;
        js.executeScript("arguments[0].click();", driver1.findElement(By.id("login2")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver1.findElement(By.id("loginusername")).sendKeys(user);
        driver1.findElement(By.id("loginpassword")).sendKeys(pass);
        Assert.assertTrue(driver1.findElement(By.id("loginpassword")).isDisplayed());
        System.out.println("Login test executed for: " + user);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.set(new ChromeDriver());
        System.out.println("Starting test");
    }

    @AfterMethod
    public void afterMethod() {
        WebDriver driver1 = driver.get();
        if (driver1 != null) {
            driver1.quit();  
        }
    }
}