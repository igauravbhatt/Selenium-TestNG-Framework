package com.selenium_testng.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium_testng.base.base;
import com.selenium_testng.pages.Dashboard;
import com.selenium_testng.pages.LeaveEntitlements;
import com.selenium_testng.pages.Login;



public class TC02_Dashboard extends baseTest {
    LeaveEntitlements leaveentitlements;
@Test
    public void verifypageHeader(){
        Dashboard dashboard = login.loginToApp("Admin", "admin123");
        Assert.assertEquals(dashboard.getPageHeader().getText(), "Dashboard");      
        pom.getScreenshotObject().screenshot("DashboardPageHeader"); 
       
    }

    
}