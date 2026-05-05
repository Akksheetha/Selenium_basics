//package StepDefinitions;
//
//import io.cucumber.java.Before;
//import io.cucumber.java.After;
//import io.cucumber.java.en.*;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.time.Duration;
//
//public class HooksPractice {
//
//    WebDriver driver;
//
//    @Before
//    public void setup() {
//        driver = new ChromeDriver();
//        System.out.println("------Before Execution-------");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/");
//        driver.findElement(By.id("login2")).click();
//    }
//
//    @After
//    public void tearDown() {
//    	System.out.println("------After Execution--------");
//        driver.quit();
//    }
//
//    @When("user enters userName as {string}")
//    public void user_enters_user_name_as(String username) {
//        driver.findElement(By.id("loginusername")).sendKeys(username);
//    }
//
//    @When("user enters password as {string}")
//    public void user_enters_password_as(String password) {
//        driver.findElement(By.id("loginpassword")).sendKeys(password);
//    }
//
//    @When("clicks Login button")
//    public void clicks_login_button() {
//        driver.findElement(By.xpath("//button[text()='Log in']")).click();
//    }
//
//    @Then("user should be able to login successfully")
//    public void user_should_be_able_to_login_successfully() throws InterruptedException {
//        Thread.sleep(3000);
//        String user = driver.findElement(By.id("nameofuser")).getText();
//        System.out.println("Logged in user: " + user);
//    }
//
//    // ================= INVALID =================
//
//    @When("user tries to login with invalid credentials")
//    public void invalid_login() {
//        driver.findElement(By.id("loginusername")).sendKeys("wrong");
//        driver.findElement(By.id("loginpassword")).sendKeys("wrong");
//    }
//
//    @When("clicks the login button")
//    public void clicks_the_login_button() {
//        driver.findElement(By.xpath("//button[text()='Log in']")).click();
//    }
//
//    // ================= BLANK =================
//
//    @When("user tries to login without filling the credentials")
//    public void blank_login() {
//        // do nothing (fields empty)
//    }
//
//    @When("click the login button")
//    public void click_the_login_button() {
//        driver.findElement(By.xpath("//button[text()='Log in']")).click();
//    }
//
//
//    @Then("popup message should be displayed successfully")
//    public void popup_message_should_be_displayed_successfully() {
//        String alertText = driver.switchTo().alert().getText();
//        System.out.println(alertText);
//        driver.switchTo().alert().accept();
//    }
//}