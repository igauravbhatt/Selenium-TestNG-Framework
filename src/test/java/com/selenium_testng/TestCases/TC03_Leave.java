package com.selenium_testng.TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.selenium_testng.pages.Dashboard;



public class TC03_Leave extends baseTest{      

    @Test
    public void VerifyEmployeeName() throws InterruptedException {        
        login.loginToApp("Admin", "admin123");
        pom.getleaveentitlementsPageObject().clickonAssignLeave("b");
        pom.getleaveentitlementsPageObject().getEmpName();   
        
    }

}