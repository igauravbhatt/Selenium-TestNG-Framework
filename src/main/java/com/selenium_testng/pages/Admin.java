package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Admin {

    WebDriver driver;
    commonMethods common;

    @FindBy(xpath = "//span/h6[text()='Admin']")
    public WebElement AdminHeader;

    @FindBy(linkText = "Admin")
    WebElement Adminlink;

    public Admin(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }
public void navigateToAdminPage(){
        common.waitAndClick(Adminlink);
        System.out.println("Admin link clicked");
}
    public String getAdminHeaderText() {
        System.out.println("Header returned"+ AdminHeader.getText());
        return AdminHeader.getText();
    }
}