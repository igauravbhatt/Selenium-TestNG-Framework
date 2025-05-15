package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Myinfo {

    WebDriver driver;
    commonMethods common;
    @FindBy(xpath = "//span[text()='My Info']")
    public WebElement MyInfoHeader;

    @FindBy(linkText = "My Info")
    WebElement myInfoLink;
    

    public Myinfo(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }

    public void navigateToMyinfoPage() {
        common.waitAndClick(myInfoLink);
        System.out.println("MyInfo Link Clicked");
    }

    public String getMyInfoHeaderText() {
        System.out.println("Header retunred"+MyInfoHeader.getText());
        return MyInfoHeader.getText();
    }
}