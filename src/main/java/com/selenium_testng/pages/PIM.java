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

    @FindBy(linkText = "PIM")
    public WebElement PIMLink;

    commonMethods common;

    public PIM(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }
    public void navigateToPIMPage() {
        common.waitAndClick(PIMLink);
        System.out.println("PIM link clicked");
    }

    public String getPIMHeaderText() {
        System.out.println("Header retunred"+PIMHeader.getText());
        return PIMHeader.getText();
    }
}