package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium_testng.utils.commonMethods;


public class Time {
   
    WebDriver driver;
    public Time(WebDriver driver, commonMethods common){
    this.driver = driver;
    }


    public Time(WebDriver driver2, commonMethods common) {
        //TODO Auto-generated constructor stub
    }


    @FindBy(xpath = "//span/h6[text()='Admin']")
    public WebElement AdminHeader;

    public String getHeader(){
    return AdminHeader.getText();
    }

}