package testng_practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class SampleTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Start the test");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); 

        driver = new ChromeDriver(options);
        driver.get("https://demoblaze.com/");
    }

    @Test
    public void validation() {

        SoftAssert sa = new SoftAssert();

        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys("Admin");
        driver.findElement(By.id("loginpassword")).sendKeys("admin");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String actualUser = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        ).getText();

        sa.assertEquals(actualUser, "Welcome Admin", "Login failed");
        System.out.println("Login successful: " + actualUser);

        String title = driver.getTitle();
        sa.assertEquals(title, "STORE", "Page title mismatch");
        System.out.println("Page Title: " + title);

        sa.assertAll(); 
    }

    @Test(dependsOnMethods = "validation")
    public void invaliduser() {

        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys("wronguser"); 
        driver.findElement(By.id("loginpassword")).sendKeys("admin");     
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String msg = alert.getText();

            System.out.println("Alert message: " + msg);

            Assert.assertEquals(msg, "Wrong password.");
            alert.accept();

        } catch (Exception e) {
            Assert.fail("Expected alert, but login succeeded");
        }
    }

    @Test
    public void invalidpassword() {

        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys("Admin");
        driver.findElement(By.id("loginpassword")).sendKeys("wrongpassword"); 
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();

        System.out.println("Alert message: " + alertMessage);

        Assert.assertEquals(alertMessage, "Wrong password.");
        alert.accept();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}