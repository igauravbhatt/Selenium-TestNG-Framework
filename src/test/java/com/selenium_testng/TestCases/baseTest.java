package com.selenium_testng.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium_testng.base.PageObjectManager;
import com.selenium_testng.base.base;
import com.selenium_testng.pages.Login;
import com.selenium_testng.utils.PropertyReader;
import com.selenium_testng.utils.commonMethods;

public class baseTest extends base {

    protected commonMethods common;
    protected PageObjectManager pom;
    protected Login login;
    PropertyReader propertyReader;

    @BeforeMethod
    public void setUp() throws IOException {

        init(); // From BasePage
        common = new commonMethods(getDriver());
        pom = new PageObjectManager(getDriver(), common);
        System.out.println("pom= "+pom+" driver= "+getDriver());
        login = pom.getLoginPageObject();
        propertyReader = new PropertyReader();
    }

    @AfterMethod
    public void tearDown() {
       
        // Get the WebDriver instance for the current thread
        WebDriver currentDriver = getDriver();

        if (currentDriver != null) {
            try {
                currentDriver.quit(); // Attempt to quit the browser
                System.out.println("Browser closed successfully for test: " + Thread.currentThread().getName());
            } catch (Exception e) {
                // Log any exceptions that occur during quit
                System.err.println("Error closing browser for test " + Thread.currentThread().getName() + ": " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging
            } finally {
                // Always attempt to remove the ThreadLocal variable, even if quit fails
                unload(); // Removes the driver from ThreadLocal
            }
        } else {
            System.out.println("No browser instance found to close for test: " + Thread.currentThread().getName());
        }
    }
}
    

