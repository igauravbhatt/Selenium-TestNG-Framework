package com.selenium_testng.TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium_testng.pages.Time;




public class TC16_TimeHeader extends baseTest{
    Time time;

@Test
public void verifyTimeHeader(){
    time = pom.getTimePageObject();
    login.loginToApp("Admin", "admin123");
    time.navigateToTimePage();
    String Header = time.getTimeHeader();
    Assert.assertEquals(Header, "Time");
}
    
}


