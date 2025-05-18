package com.selenium_testng.TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC03_Leave extends baseTest{      

     @Test
     public void verifyLeavepageHeader(){
        login.loginToApp("Admin", "admin123");
        String Header = pom.getLeavePageObject().getLeaveHeaderText();
        pom.getScreenshotObject().screenshot(Header);  
        Assert.assertEquals(Header, "Leave");
              
       
    }
}