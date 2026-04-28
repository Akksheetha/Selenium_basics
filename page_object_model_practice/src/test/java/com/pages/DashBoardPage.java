package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
  
	WebDriver driver;
	By dashBoardTitle = By.xpath("//h6[normalize-space()='Dashboard']");
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getHomePageText() {
		return driver.findElement(dashBoardTitle).getText();
	}
}
