package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pages.DemoBlazeBasePage;
import com.pages.DemoBlazeLogin;

public class DemoBlazeLoginTest extends DemoBlazeBasePage{
	public DemoBlazeLoginTest(WebDriver driver) {
		super(driver);
	}
	DemoBlazeLogin objlogin;
	
	@Test
	public void LoginTest() {
		objlogin.click();
		objlogin.login();
	}
	

}
