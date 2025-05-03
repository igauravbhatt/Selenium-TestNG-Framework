package com.selenium_testng.Practice_Testcases;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Verifyrightclick {
    WebDriver driver;
    WebDriverWait w;
      @BeforeClass
    public void init() {
        // System.setProperty("webdriver.chrome.driver",
        // "C:\Users\dell\Desktop\stng\target\chromedriver.exe");
        // driver = new ChromeDriver();
        // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        driver = new ChromeDriver(options);
        w = new WebDriverWait(driver, Duration.ofSeconds(10));
        login();

    }

    public void login() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement((By.xpath("//input[@name='username']"))).sendKeys("Admin");
        driver.findElement((By.xpath("//input[@name='password']"))).sendKeys("admin123");
        driver.findElement(By.xpath("//div/button[@type='submit']")).submit();

        // driver.findElement(By.xpath("//button[@title='Assign Leave']")).click();
    }      
    @Test
    public void rightclickonMyInfo() throws InterruptedException, AWTException{
        Robot robot = new Robot();
        WebElement MyInfo;
        try {
             MyInfo = driver.findElement(By.linkText("Mi Información"));    
        } catch (Exception e) {
             MyInfo = driver.findElement(By.linkText("My Info"));
        }
        
        Actions ac = new Actions(driver);
        ac.contextClick(MyInfo).perform();
        //ac.keyDown(Keys.ARROW_UP).perform();
        
        robot.keyPress(KeyEvent.VK_DOWN);  // Press Down Arrow
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER); // Press Enter
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
        
    }
    