package com.selenium_testng.TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;


import com.selenium_testng.pages.Dashboard;





public class TC02_Dashboard extends baseTest {
   
@Test
    public void verifypageHeader(){
        Dashboard dashboard = login.loginToApp("Admin", "admin123");
        dashboard.navigateToDashboard();
        String Header = dashboard.getDashboardHeaderText();
        Assert.assertEquals(Header, "Dashboard");
        pom.getScreenshotObject().screenshot("DashboardPageHeader");        
    }

    
}