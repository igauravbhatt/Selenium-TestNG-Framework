package com.selenium_testng.Practice_Testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//@Listeners(com.selenium_testng.ScreenshotListener.class)
public class Synchronization {
    WebDriver driver;
    WebDriverWait w;
    static final  String folderpath = "C:\\Users\\dell\\Desktop\\ss";
   static{
    
    File folder = new File(folderpath);
    if (!folder.exists()) {
        boolean created = folder.mkdirs();
        if (created) {
            System.out.println("Folder created at " + folderpath);
        } else {
            System.out.println("Failed to create folder at " + folderpath);
        }
    } else
        System.out.println("Folder already exist at " + folderpath);
    }

    @BeforeClass
    public void init() {
        // System.setProperty("webdriver.chrome.driver",
        // "C:\\Users\\dell\\Desktop\\stng\\target\\chromedriver.exe");
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
        capture("Login");
        driver.findElement(By.xpath("//div/button[@type='submit']")).submit();

        // driver.findElement(By.xpath("//button[@title='Assign Leave']")).click();
    }

    @Test(priority = 1)
    public void syncwithhardassert() {
        WebElement h = driver.findElement(By.xpath("//span/h6"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(h));
        String expectedtext = "Dashboard";
        Assert.assertEquals(h.getText(), expectedtext);
        capture("syncwithhardassert");
        System.out.println(h.getText() + " " + expectedtext);
    }
   
    public void capture(String testName) {
        // challange7

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\dell\\Desktop\\ss\\"+testName +" "+ System.currentTimeMillis() + ".png");
              
        try {

            FileUtils.copyFile(source, dest);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Test(priority = 0)
    public void syncwithsoftassert() {
        WebElement h = driver.findElement(By.xpath("//span/h6"));
        SoftAssert softassert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(h));
        String expectedtext = "Dashboard";
        String actualText = h.getText();
        softassert.assertEquals(actualText, expectedtext, "text verification failed");
        WebElement pp = driver.findElement(By.xpath("//img[@class=\"oxd-userdropdown-img\"]"));
        softassert.assertTrue(pp.isDisplayed(), "profile picture not displayed");
        capture("syncwithsoftassert");       
        System.out.println("captured");
        softassert.assertAll();

    }


}
