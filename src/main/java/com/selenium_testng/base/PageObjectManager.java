package com.selenium_testng.base;

import org.openqa.selenium.WebDriver;

import com.selenium_testng.pages.Dashboard;
import com.selenium_testng.pages.LeaveEntitlements;
import com.selenium_testng.pages.Login;
import com.selenium_testng.utils.commonMethods;
import com.selenium_testng.utils.screenshotListener;

public class PageObjectManager {
    WebDriver driver;
    screenshotListener capture;
    commonMethods common;  
    Login login;
    Dashboard dashboard;
      LeaveEntitlements leaveentitlements;


    public PageObjectManager(WebDriver driver,commonMethods common){

        this.driver =  driver;
        this.common = common;
    } 

    public screenshotListener getScreenshotObject(){
        if(capture == null){
            capture = new screenshotListener(driver);
        } 
            return capture;        
        
    }

    public Login getLoginPageObject(){
        if(login == null){
            login = new Login(driver , common);
        }
        return login;
    }

    public Dashboard getDashboardPageObject(){
        if(dashboard == null){
            dashboard = new Dashboard(driver , common);
        }
        return dashboard;
    }

    public LeaveEntitlements getleaveentitlementsPageObject(){
        if(leaveentitlements == null){
            leaveentitlements = new LeaveEntitlements(driver , common);
        }
        return leaveentitlements;
    }
}
