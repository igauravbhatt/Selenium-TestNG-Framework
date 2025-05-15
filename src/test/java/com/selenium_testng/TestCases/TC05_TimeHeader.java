package com.selenium_testng.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_TimeHeader extends baseTest{

    @Test
    public void verifyHeader(){
        String Header;
        Header = propertyReader.get("Time.Header");
        System.out.println(Header);
        Assert.assertEquals(Header, "Time");
    }
    
}
