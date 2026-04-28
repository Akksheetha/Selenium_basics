package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoBlazeLogin extends DemoBlazeBasePage{

	public DemoBlazeLogin(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "login2")
	WebElement loginbtn1;
	
    public void click() {
    	loginbtn1.click();
    }
	
    @FindBy(id="loginusername")
    WebElement user;
    
    @FindBy(id="loginpassword")
    WebElement pass;
    
    @FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    WebElement loginbtn;
    
    public void login() {
    	user.sendKeys("Admin");
    	pass.sendKeys("admin");
    	loginbtn.click();
    	
    }
	

}
