package com.selenium_testng.Practice_Testcases;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Verifyemplist {
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

        // driver.findElement(By.xpath("//button[@title='Assign Leave']")).click();
    }
@Test
    public void getemplist(){
       WebElement link =  driver.findElement(By.linkText("PIM"));
       
        w.until(ExpectedConditions.visibilityOf(link));
        link.click();
        Set<String> empNames = new HashSet<>();
        List <WebElement> empList = driver.findElements(By.xpath("//div[@class=\"orangehrm-container\"]//div[@class=\"oxd-table-body\"]//div[@role=\"row\"]/div[3]"));
        for(WebElement name : empList){
           // System.out.println(name.getText());
           String nm = name.getText().trim();
           nm = nm.replaceAll("^, ", "");
           empNames.add(nm);
           
        }
        for(String emp : empNames){
            System.out.println(emp);
        }
      

        
        
    }
    }