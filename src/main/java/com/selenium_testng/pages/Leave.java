package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Leave {

    WebDriver driver;
    commonMethods common;

    @FindBy(xpath = "//span[text()='Leave']")
    public WebElement LeaveHeader;

    @FindBy(linkText = "Leave")
    public WebElement Leavelink;

    public Leave(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLeavePage() {
       common.waitAndClick(Leavelink);
       System.out.println("Leave link clicked");
    }

    public String getLeaveHeaderText() {
        System.out.println("Header returned "+LeaveHeader.getText());
        return LeaveHeader.getText();
    }
}