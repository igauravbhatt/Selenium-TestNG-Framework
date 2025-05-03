package com.selenium_testng.Practice_Testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class LeaveEntitlements {
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

    WebElement empNameTextbox;

    @Test
    public void LeaveEntitlementsForm() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()=\"Leave\"]")).click();
        driver.findElement(By.xpath("//span[text()='Entitlements ']")).click();
        driver.findElement(By.linkText("Add Entitlements")).click();
        driver.findElement(By.xpath("//label[text()='Multiple Employees']")).click();
        driver.findElement(By.xpath("//label[text()='Individual Employee']")).click();
        empNameTextbox = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        empNameTextbox.sendKeys("Ran");
        // Thread.sleep(3000);By.xpath("//div[@role='listbox']")
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        // List <WebElement> empList =
        // driver.findElements(By.xpath("//div[@role='listbox']/div"));
        // //WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.());
        // if(empList.getFirst().getText().contains("Searching")){
        // w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']")));
        // System.out.println(empList.getFirst().getText());
        // } else {
        // for(WebElement empName : empList){
        // System.out.println(empName.getText());
        // }
        // }

        w.until(driver -> {
            List<WebElement> empList = driver.findElements(By.xpath("//div[@role='listbox']/div"));

            for (WebElement empName : empList) {
                try {
                    empList = driver.findElements(By.xpath("//div[@role='listbox']/div"));
                    String tmp = empName.getText().trim();
                    if (!tmp.equalsIgnoreCase("Searching....")) {

                        return true;
                    }
                } catch (StaleElementReferenceException e) {
                    return false;
                }

            }

            return false;
        });

        List<WebElement> empList = driver.findElements(By.xpath("//div[@role='listbox']/div"));
        for (WebElement empName : empList) {
            String txt = empName.getText().trim();
            if (!txt.equalsIgnoreCase("Searching....") && txt.equalsIgnoreCase("DHINA KARAN P")) {
                empName.click();
                System.out.println(txt);
                break;
            }
        }
        boolean b = empNameTextbox.getDomProperty("value").equals("DHINA KARAN P");
        Assert.assertTrue(b);
    }

    @Test
    public void leavetype() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='-- Select --']")).click();
        List<WebElement> leaveType = driver
                .findElements(By.xpath("//div[@role='option' and @class='oxd-select-option']/span"));
        w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                (By.xpath("//div[@role='option' and @class='oxd-select-option']/span"))));
        for (WebElement lt : leaveType) {
            // leaveType = driver.findElements(By.xpath("//div[@role='option' and
            // @class='oxd-select-option']/span"));
            System.out.println(lt.getText());
            if (lt.getText().equals("US - Personal")) {
                System.out.println(lt.getText());
                lt.click();
                break;
            }
//div/input[@class='oxd-input oxd-input--active'][1]

       
        }
        driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")).sendKeys("10");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        //button[text()=' Confirm ']
        System.out.println(driver.findElement(By.xpath("//button[text()=' Confirm ']")).getText());
        driver.findElement(By.xpath("//button[text()=' Confirm ']")).click();
        //w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-dialog-container-default--inner']")));
        //System.out.println("displayed");
        
    }

}
