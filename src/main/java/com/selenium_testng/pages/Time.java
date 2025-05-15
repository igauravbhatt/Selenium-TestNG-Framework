package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Time {

    WebDriver driver;
    commonMethods common;

    public Time(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Time")
    public WebElement TimeLink;

    @FindBy(xpath = "//span/h6[text()='Time']")
    public WebElement TimeHeader;

    public void navigateToTimePage() {
        common.waitAndClick(TimeLink);
        System.out.println("Time Link Clicked");
    }

    public String getTimeHeader() {
        System.out.println("Header returned "+TimeHeader.getText());
        return TimeHeader.getText();
    }

}