package testng_practice;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoggingPractice {
    private static Logger logger = LogManager.getLogger(LoggingPractice.class);
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        logger.info("Starting the test");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");  
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");

        driver = new ChromeDriver(options);

        driver.get("https://demoblaze.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        logger.info("DemoBlaze Website opened");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void validation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ((JavascriptExecutor) driver).executeScript(
            "document.querySelector('.carousel').remove();"
        );

        Thread.sleep(1000);

        // Now click login
        WebElement loginBtn = driver.findElement(By.id("login2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);

        driver.findElement(By.id("loginusername")).sendKeys("Admin");
        driver.findElement(By.id("loginpassword")).sendKeys("admin");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String actualUser = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        ).getText();

        logger.info("Login successful with valid credentials");
        logger.debug("Logged in with username=Admin and password=admin");
    }

    @Test(priority = 1)
    public void invaliduser() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ((JavascriptExecutor) driver).executeScript(
            "document.querySelector('.carousel').remove();"
        );

        Thread.sleep(1000);

        // Now click login
        WebElement loginBtn = driver.findElement(By.id("login2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);

        driver.findElement(By.id("loginusername")).sendKeys("Admin");
        driver.findElement(By.id("loginpassword")).sendKeys("admin!");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String msg = alert.getText();
            System.out.println(msg);

            logger.info("Trying to login with invalid password");
            logger.warn("Alert for invalid password popped");

            alert.accept();
            logger.info("Alert accepted");

        } catch (Exception e) {
            String user = driver.findElement(By.id("nameofuser")).getText();
            logger.error("Logged in failed as " + user);
        }
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
