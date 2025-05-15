package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium_testng.pages.Claim;

public class TC11_MyInfoeader extends baseTest{
    Claim claim;

@Test
public void verifyClaimHeader(){
    claim = pom.getClaimPageObject();
    login.loginToApp("Admin", "admin123");
    claim.navigateToClaimPage();
    Assert.assertEquals(claim.getClaimHeaderText(), "Buzz");
}
    
}


