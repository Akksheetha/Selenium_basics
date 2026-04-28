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
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        logger.info("Starting the test");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://demoblaze.com/");

        logger.info("DemoBlaze Website opened");
    }

    // 🔥 COMMON METHOD (handles click issue)
    public void clickLogin() {

        // Wait for carousel overlay to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".carousel-item.active img")
        ));

        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("login2"))
        );

        try {
            loginBtn.click();
        } catch (Exception e) {
            // fallback if intercepted
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", loginBtn);
        }
    }

    @Test(priority = 1)
    public void invaliduser() {

        clickLogin();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
                .sendKeys("Admin");

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
            logger.error("No alert displayed for invalid login");
        }
    }

    @Test(priority = 2)
    public void validation() {

        clickLogin();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
                .sendKeys("Admin");

        driver.findElement(By.id("loginpassword")).sendKeys("admin");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String actualUser = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        ).getText();

        logger.info("Login successful with valid credentials");
        logger.debug("Logged in user: " + actualUser);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}