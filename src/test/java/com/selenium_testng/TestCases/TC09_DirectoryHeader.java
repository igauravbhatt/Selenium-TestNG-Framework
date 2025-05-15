package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium_testng.pages.Directory;

public class TC09_DirectoryHeader extends baseTest{
    Directory directory;

@Test
public void verifyClaimHeader(){
    directory = pom.getDirectoryPageObject();
    login.loginToApp("Admin", "admin123");
    directory.navigateToDirectoryPage();
    String header = directory.getDirectoryHeaderText();
    Assert.assertEquals(header, "Directory");
}
    
}


