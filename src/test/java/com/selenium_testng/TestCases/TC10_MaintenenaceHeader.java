package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium_testng.pages.Maintenance;

public class TC10_MaintenenaceHeader extends baseTest{
    Maintenance maintanance;

@Test
public void verifyClaimHeader(){
    maintanance = pom.getMaintenancePageObject();
    login.loginToApp("Admin", "admin123");
    maintanance.navigateToMaintenancePage();
    String header = maintanance.getMaintenanceHeaderText();
    Assert.assertEquals(header, "Maintenance");
}
    
}


