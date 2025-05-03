package com.selenium_testng.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class base {
    protected WebDriver driver;
    ChromeOptions options = new ChromeOptions();
        
    public WebDriver init() {
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        driver=new ChromeDriver(options);   
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));        
        
        return driver;
   }


}