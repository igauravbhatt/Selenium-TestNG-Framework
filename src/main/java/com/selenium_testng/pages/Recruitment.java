package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Recruitment {

    WebDriver driver;
    commonMethods common;

    @FindBy(xpath = "//span[text()='Recruitment']")
    public WebElement RecruitmentHeader;
    
    @FindBy(linkText = "Recruitment")
    public WebElement RecruitmentLink;

    public Recruitment(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }

   public void navigateToRecruitementPage(){
   common.waitAndClick(RecruitmentLink);   }

    public String getRecruitmentHeaderText() {
        return RecruitmentHeader.getText();
    }
}