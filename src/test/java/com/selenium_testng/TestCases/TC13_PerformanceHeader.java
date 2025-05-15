package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium_testng.pages.Performance;


public class TC13_PerformanceHeader extends baseTest{
    Performance performance;

@Test
public void verifyPerformanceHeader(){
    performance = pom.getPerformancePageObject();
    login.loginToApp("Admin", "admin123");
    performance.navigateToPerformancePage();
    String Header = performance.getPerformanceHeaderText();
    Assert.assertEquals(Header, "Performance");
}
    
}


