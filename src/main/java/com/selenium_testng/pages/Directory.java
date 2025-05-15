package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;



public class Directory {

    WebDriver driver;
    commonMethods common;

    @FindBy(xpath = "//span[text()='Directory']")
    public WebElement DirectoryHeader;
    
    @FindBy(linkText = "Directory")
    WebElement Directorylink;

    public Directory(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }

   

    public String getDirectoryHeaderText() {
        System.out.println("Header returned "+DirectoryHeader.getText());
        return DirectoryHeader.getText();
    }



    public void navigateToDirectoryPage() {
        common.waitAndClick(Directorylink);
        System.out.println("Directory link clicked");
            }



  
}