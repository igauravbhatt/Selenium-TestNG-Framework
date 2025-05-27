package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium_testng.pages.Admin;

public class TC06_AdminHeader extends baseTest{
    Admin admin;

@Test
public void verifyAdminHeader(){
    admin = pom.getAdminPageObject();
    login.loginToApp("Admin", "admin123");
    admin.navigateToAdminPage();
    String Header = admin.getAdminHeaderText();
   // pom.getScreenshotObject().screenshot(Header);  
    Assert.assertEquals(Header, "Admin");
    
}
    
}


