package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By username = By.name("username");
	By password = By.name("password");
	By titleText = By.xpath("//h5[text()=\"Login\"]");
	By loginBtn = By.xpath("//button[text()=\" Login \"]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void SetUserName(String strUsername) {
		driver.findElement(username).sendKeys(strUsername);
	}
	public void SetPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	public String getLoginTitle() {
		return driver.findElement(titleText).getText();
	}
	public void login(String strUsername,String strPassword) {
		this.SetUserName(strUsername);
		this.SetPassword(strPassword);
		this.clickLogin();
	}

}
