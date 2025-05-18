package com.selenium_testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;

public class Maintenance { 
    WebDriver driver;
    commonMethods common;

    @FindBy(xpath = "//span[text()='Maintenance']")
    public WebElement MaintenanceHeader;

    @FindBy(linkText = "Maintenance")
    public WebElement MaintenanceLink;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement ConfirmBtn;
    

    @FindBy(xpath = "//input[@name='password']")
    WebElement maintenance_textbox;

    public Maintenance(WebDriver driver, commonMethods common) {
        this.driver = driver;
        this.common = common;
        PageFactory.initElements(driver, this);
    }

    public void navigateToMaintenancePage(){
        common.waitAndClick(MaintenanceLink);
        System.out.println("Maintenance link clicked");
    }

    public String getMaintenanceHeaderText() {
        maintenance_textbox.sendKeys("admin123");
        ConfirmBtn.click();
        System.out.println("Header returned"+MaintenanceHeader.getText());
        return MaintenanceHeader.getText();
    }
}