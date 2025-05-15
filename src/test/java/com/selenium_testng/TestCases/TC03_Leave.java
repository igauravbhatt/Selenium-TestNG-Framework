package com.selenium_testng.TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC03_Leave extends baseTest{      

    @Test
    public void VerifyEmployeeName() throws InterruptedException {        
        login.loginToApp("Admin", "admin123");
        pom.getleaveentitlementsPageObject().clickonAssignLeave();
        pom.getleaveentitlementsPageObject().enterEmployeeName("anj");
        pom.getleaveentitlementsPageObject().selectEmpName("Anja Test");           
        
    }
    @Test
     public void verifyLeavepageHeader(){
        login.loginToApp("Admin", "admin123");
        String Header = pom.getLeavePageObject().getLeaveHeaderText();
        Assert.assertEquals(Header, "Header");
        pom.getScreenshotObject().screenshot("DashboardPageHeader"); 
       
    }
}