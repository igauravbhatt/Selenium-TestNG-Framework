package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;



public class Dashboard {
WebDriver driver;
commonMethods common;
public Dashboard(WebDriver driver, commonMethods common){
    this.driver = driver;
    this.common = common;
PageFactory.initElements(driver,this);

}

@FindBy(xpath = "//h6[text()='Dashboard']")
WebElement pageHeading;

public WebElement getPageHeader(){
    
    System.out.println("heading from page = "+pageHeading.getText());
    return pageHeading;

}


}
