package com.selenium_testng.TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium_testng.utils.screenshotListener;




public class TC01_login extends baseTest {
   
    @Test
    public void verifyLogin() {
        login.loginToApp("Admin", "admin123");    // move this into testcase to cover negative login in the morning
        Assert.assertEquals(login.getPageHeader().getText(), "Dashboard");
        System.out.println("---Logged successfull and Dashboard visible---");
        pom.getScreenshotObject().screenshot("VerifyLogin");
        
        
    }
    @Test
    public void verifyInvalidLogin(){

       Boolean result = login.VerifyLoginNegative("Admin", "adminf1283");
       Assert.assertTrue(result, "❌ Error: 'Invalid credentials' message not shown as expected."); 
     

}}