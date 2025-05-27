package com.selenium_testng.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
    
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    WebDriver localDriver;

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        // options.addArguments("--headless=new");
        localDriver = new ChromeDriver(options);
        localDriver.manage().window().maximize();
        localDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.set(localDriver);
        
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void unload() {
        driver.remove();
    }

}