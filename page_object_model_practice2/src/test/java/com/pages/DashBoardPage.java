package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashBoardPage extends com.pages.BasePage1 {

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    public WebElement dashBoardTitle;

    public String getHomePageText() {
        return dashBoardTitle.getText();
    }
}