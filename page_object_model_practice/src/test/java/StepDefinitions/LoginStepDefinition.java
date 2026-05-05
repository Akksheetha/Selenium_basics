package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LoginStepDefinition {

    WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();      
        driver.get("https://www.demoblaze.com/");
    }

    @When("user enters userName as {string}")
    public void user_enters_user_name_as(String username) throws InterruptedException {
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys(username);
    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
        driver.findElement(By.id("loginpassword")).sendKeys(password);
    }

    @When("clicks Login button")
    public void clicks_login_button() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("user should be able to login successfully")
    public void user_should_be_able_to_login_successfully() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @When("user tries to login with invalid credentials")
    public void invalid_login() throws InterruptedException {
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("wrong");
        driver.findElement(By.id("loginpassword")).sendKeys("Password");
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("popup message should be displayed successfully")
    public void popup_message_should_be_displayed_successfully() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.quit();
    }

    @When("user tries to login without filling the credentials")
    public void blank_login() throws InterruptedException {
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
    }

    @When("click the login button")
    public void click_the_login_button() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }
}