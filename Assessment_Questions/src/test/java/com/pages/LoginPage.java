package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver){
		super(driver);
	}

	@FindBy(linkText = "Signup / Login")
	WebElement signupbtn;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement pass;
	
	public void clickLogin() {
		signupbtn.click();
		email.sendKeys("2k22csbs03@kiot.ac.in");
		pass.sendKeys("Pass@1234");
	}
}
