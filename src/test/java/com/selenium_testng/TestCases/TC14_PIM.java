package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium_testng.pages.PIM;



public class TC14_PIM extends baseTest{
    PIM pim;

@Test
public void verifyPIMHeader(){
    pim = pom.getPIMPageObject();
    login.loginToApp("Admin", "admin123");
    pim.navigateToPIMPage();
    String Header = pim.getPIMHeaderText();
    Assert.assertEquals(Header, "PIM");
}
    
}


