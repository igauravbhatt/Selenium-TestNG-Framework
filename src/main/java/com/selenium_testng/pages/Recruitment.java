package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Recruitment {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Recruitment']")
    public WebElement RecruitmentHeader;

    public Recruitment(WebDriver driver, commonMethods common) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Recruitment(WebDriver driver2, commonMethods common) {
        //TODO Auto-generated constructor stub
    }

    public String getRecruitmentHeaderText() {
        return RecruitmentHeader.getText();
    }
}