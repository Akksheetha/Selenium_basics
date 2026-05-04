package com.tests;

import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginPageTest extends BaseTest{
	
	LoginPage obj;
	
	@Test
	public void loginTest() {
		obj=new LoginPage(driver);
		obj.clickLogin();
	}
	
}
