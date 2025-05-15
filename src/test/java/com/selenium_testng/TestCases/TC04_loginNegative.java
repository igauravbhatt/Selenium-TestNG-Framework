package com.selenium_testng.TestCases;



import org.testng.Assert;

import org.testng.annotations.Test;




public class TC04_loginNegative extends baseTest{
         

    @Test
    public void verifyInvalidLogin(){

       Boolean result = login.VerifyLoginNegative("Admin", "adminf1283");
       pom.getScreenshotObject().screenshot("VerifyLogin_Negative");
       Assert.assertTrue(result, "❌ Error: 'Invalid credentials' message not shown as expected."); 
     

}

}