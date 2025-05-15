package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Claim {

    WebDriver driver;
    commonMethods common;
        

    @FindBy(xpath = "//span[text()='Claim']")
    public WebElement ClaimHeader;

    @FindBy(linkText = "Claim")
    public WebElement Claimlink;
   

    public Claim(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }
    public void navigateToClaimPage(){
        common.waitAndClick(Claimlink);
        System.out.println("Claim link clicked");
}
    public String getClaimHeaderText() {
        System.out.println("Claim Header Returned");
        return ClaimHeader.getText();
    }
}