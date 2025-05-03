package com.selenium_testng.Practice_Testcases;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class MultipleWindowsAndTabs {
    WebDriver driver;
    WebDriverWait w;

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
        driver.findElement(By.xpath("//div/button[@type='submit']")).submit();

        driver.findElement(By.xpath("//button[@title='Assign Leave']")).click();
    }

    // challange 4
    @Test
    public void multiplewindowandtab() throws InterruptedException {
        int count = 0, scroll = 0;
        System.out.println(++count + " I am in " + driver.getTitle());
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        String MainWindow = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();

        for (String window1 : allwindows) {
            if (!window1.equals(MainWindow)) {
                driver.switchTo().window(window1);
                System.out.println(++count + " I am in " + driver.getTitle());
                break;
            }

        }

        WebElement element = driver.findElement(By.partialLinkText("OrangeHRM API"));
        while (scroll <5) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2500);");
           // w.until(ExpectedConditions.visibilityOf(element));
           Thread.sleep(500);
            scroll++;
        }
        
        w.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        allwindows = driver.getWindowHandles();

        for (String window : allwindows) {
            if (!window.equals(MainWindow) && !window.equals(driver.getWindowHandle())) {
                driver.switchTo().window(window);
                System.out.println(" Page title is " + driver.getTitle());

            }

        }
        
        String ExpectedURL = "OrangeHRM apiDoc";
        //w.until(ExpectedConditions.not(ExpectedConditions.titleIs("Loading...")));
        w.until(ExpectedConditions.titleContains("Orange"));
        System.out.println(" Page title is " + driver.getTitle()+" and expected is "+ExpectedURL);
        Assert.assertEquals(driver.getTitle(), ExpectedURL);
        System.out.println("✅ Assertion Passed! Page title is correct.");
        driver.quit();
       
    }
}
