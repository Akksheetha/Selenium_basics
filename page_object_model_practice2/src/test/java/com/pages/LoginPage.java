package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage1{
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="username")
	public WebElement userName;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//h5[normalize-space()='Login']")
	public WebElement login_text;
	
	@FindBy(xpath="//button[normaliize-space()='Login']")
	public WebElement login;
	
	
	public void login(String strUsername,String strPassword) {
		userName.sendKeys(strUsername);
		password.sendKeys(strPassword);
		login.click();
	}
	public String getLoginPageText() {
		return login_text.getText();
	}

}
