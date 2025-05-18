package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium_testng.pages.Maintenance;

public class TC10_MaintenenaceHeader extends baseTest{
    Maintenance maintanance;

@Test
public void verifyMaintenanceHeader(){
    maintanance = pom.getMaintenancePageObject();
    login.loginToApp("Admin", "admin123");
    maintanance.navigateToMaintenancePage();
    String Header = maintanance.getMaintenanceHeaderText();
    pom.getScreenshotObject().screenshot(Header);
    Assert.assertEquals(Header, "Maintenance");
    
}
    
}


