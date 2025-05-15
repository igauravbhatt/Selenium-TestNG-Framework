package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class PIM {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='PIM']")
    public WebElement PIMHeader;

    public PIM(WebDriver driver, commonMethods common) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPIMHeaderText() {
        return PIMHeader.getText();
    }
}