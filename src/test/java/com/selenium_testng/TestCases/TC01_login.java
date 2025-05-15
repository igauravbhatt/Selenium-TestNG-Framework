package com.selenium_testng.TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_login extends baseTest {
   
    @Test
    public void verifyLogin() {
        login.loginToApp("Admin", "admin123");   
        Assert.assertEquals(login.getPageHeader().getText(), "Dashboard");
        System.out.println("---Logged successfull and Dashboard visible---");
        pom.getScreenshotObject().screenshot("VerifyLogin");
        
        
    }
    }