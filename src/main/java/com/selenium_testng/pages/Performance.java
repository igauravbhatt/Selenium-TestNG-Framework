package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Performance {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Performance']")
    public WebElement PerformanceHeader;

    public Performance(WebDriver driver, commonMethods common) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Performance(WebDriver driver2, commonMethods common) {
        //TODO Auto-generated constructor stub
    }

    public String getPerformanceHeaderText() {
        return PerformanceHeader.getText();
    }
}