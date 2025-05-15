package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.selenium_testng.pages.Recruitment;



public class TC15_RecruitementHeader extends baseTest{
    Recruitment recruitment;

@Test
public void verifyTimeHeader(){
    recruitment = pom.getRecruitmentPageObject();
    login.loginToApp("Admin", "admin123");
    recruitment.navigateToRecruitementPage();
    String Header = recruitment.getRecruitmentHeaderText();
    Assert.assertEquals(Header, "Time");
}
    
}


