package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium_testng.pages.Buzz;

public class TC07_BuzzHeader extends baseTest{
    Buzz buzz;

@Test
public void verifybuzzHeader(){
    buzz = pom.getBuzzPageObject();
    login.loginToApp("Admin", "admin123");
    buzz.navigateToBuzzPage();
    Assert.assertEquals(buzz.getBuzzHeaderText(), "Buzz");
}
    
}


