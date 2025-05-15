package com.selenium_testng.TestCases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import com.selenium_testng.base.PageObjectManager;
import com.selenium_testng.base.base;

import com.selenium_testng.pages.Login;
import com.selenium_testng.utils.PropertyReader;
import com.selenium_testng.utils.commonMethods;

public class baseTest extends base {
    protected WebDriver driver;
    protected commonMethods common;
    protected PageObjectManager pom;
    protected Login login;
    PropertyReader propertyReader;
    

    @BeforeMethod
    public void setUp() throws IOException {

        driver = init(); // From BasePage
        common = new commonMethods(driver);
        pom = new PageObjectManager(driver, common);
        login = pom.getLoginPageObject(); 
        propertyReader=new PropertyReader();
    }
       
    @AfterClass
    public void tearDown() {
      //  driver.quit();
    }

}