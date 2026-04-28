package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class DashBoardTest extends BaseTest {

	LoginPage objLogin;
	DashBoardPage objdashBoard;
	
	@Test(priority=0)
	public void dashBoardTest() {
		objLogin = new LoginPage(driver);
		objdashBoard = new DashBoardPage(driver);
		objLogin.login("Admin", "admin123");
		String dashBoardTitle = objdashBoard.getHomePageText();
		Assert.assertTrue(dashBoardTitle.contains("Dashboard"));
	}

}
