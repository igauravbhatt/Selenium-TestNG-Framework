package com.selenium_testng.TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;



public class TC04_loginNegative extends baseTest {
   
   

    @Test
    public void verifyInvalidLogin() {
        
    
        Boolean result = login.VerifyLoginNegative("Admin", "admin1423");
      //  pom.getScreenshotObject().screenshot("Negative_Login");
        Assert.assertTrue(result, "❌ Error: 'Invalid credentials' message not shown as expected.");
     

    }

}