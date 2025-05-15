package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Performance {

    WebDriver driver;
    commonMethods common;
    

    @FindBy(xpath = "//span[text()='Performance']")
    public WebElement PerformanceHeader;
    @FindBy(linkText = "Performance")
    public WebElement PerformanceLink;

    public Performance(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }

    public void navigateToPerformancePage(){
        common.waitAndClick(PerformanceLink);
        System.out.println("Performance Link Clicked");
    }

    public String getPerformanceHeaderText() {
        System.out.println("Header returned"+PerformanceHeader.getText());
        return PerformanceHeader.getText();
    }
}