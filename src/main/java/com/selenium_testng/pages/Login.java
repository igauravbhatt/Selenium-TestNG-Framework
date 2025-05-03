package com.selenium_testng.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium_testng.utils.commonMethods;



public class Login {
    WebDriver driver;
    commonMethods common;
    Dashboard dashboard;
    public Login(WebDriver driver, commonMethods common){
        this.driver=driver;
        this.common =common;
       PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    
    @FindBy(xpath = "//div/button[@type='submit']")
    WebElement submit;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement pageHeader;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement InvalidLogin;
      
    By InvalidLoginBy = By.xpath("//p[text()='Invalid credentials']");
    By pageHeaderBy = By.xpath ( "//h6[text()='Dashboard']");   

    public Dashboard loginToApp(String uname,String pwd) {
        userName.sendKeys(uname);
        password.sendKeys(pwd);
        submit.submit();
        common.WaitTillVisible(pageHeaderBy);
        return new Dashboard(driver,common);
    }

    public By getPageHeaderBy(){ //i am getter and will return page heading
        return pageHeaderBy;
      }

    public WebElement getPageHeader(){ //i am getter and will return page heading
        return pageHeader;
      }

    public boolean VerifyLoginNegative(String uname, String pwd) {
     
        userName.sendKeys(uname);
        password.sendKeys(pwd);       
        submit.submit();
       
      try {
        InvalidLogin = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
        return InvalidLogin.isDisplayed() && InvalidLogin.getText().contains("Invalid");
      } catch (NoSuchElementException e) {
        return false;
      }
        
      }
}

    