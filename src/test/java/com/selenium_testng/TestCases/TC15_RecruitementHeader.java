package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.selenium_testng.pages.Recruitment;



public class TC15_RecruitementHeader extends baseTest{
    Recruitment recruitment;

@Test
public void verifyRecrutementHeader(){
    recruitment = pom.getRecruitmentPageObject();
    login.loginToApp("Admin", "admin123");
    recruitment.navigateToRecruitementPage();
    String Header = recruitment.getRecruitmentHeaderText();
  //  pom.getScreenshotObject().screenshot(Header);
    Assert.assertEquals(Header, "Recruitment");
    
}
    
}


