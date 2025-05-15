package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium_testng.pages.Myinfo;

public class TC11_MyInfoHeader extends baseTest{
    Myinfo myinfo;

@Test
public void verifyMyInfoHeader(){
    myinfo = pom.getMyInfoPageObject();
    login.loginToApp("Admin", "admin123");
    myinfo.navigateToMyinfoPage();
    String Header = myinfo.getMyInfoHeaderText();
    Assert.assertEquals(Header, "My Info");
}
    
}


