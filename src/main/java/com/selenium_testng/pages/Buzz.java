package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Buzz {

    WebDriver driver;
    commonMethods common;

    @FindBy(xpath = "//span[text()='Buzz']")
    public WebElement BuzzHeader;

    @FindBy(linkText = "Buzz")
    WebElement BuzzLink;

    public Buzz(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }

    public void navigateToBuzzPage() {
        common.waitAndClick(BuzzLink);
        System.out.println("Buzz link clicked");
    }

    public String getBuzzHeaderText() {
        System.out.println("Header returned" + BuzzHeader.getText());
        return BuzzHeader.getText();
    }
}