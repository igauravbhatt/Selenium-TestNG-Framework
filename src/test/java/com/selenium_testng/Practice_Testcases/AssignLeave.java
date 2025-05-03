package com.selenium_testng.Practice_Testcases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class AssignLeave {
    WebDriver driver;
@BeforeClass
public void init(){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Desktop\\stng\\target\\chromedriver.exe");
    driver=new ChromeDriver();

}

//challange 3
@Test(priority = 1)
public void ValidateAssignLeave() throws InterruptedException {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   // driver.manage().window().maximize();
    driver.findElement((By.xpath("//input[@name='username']"))).sendKeys("Admin");;
    driver.findElement((By.xpath("//input[@name='password']"))).sendKeys("admin123");
  //  driver.findElement(By.xpath("//div/button[@type='submit']")).click();
    driver.findElement(By.xpath("//div/button[@type='submit']")).submit();
  
    driver.findElement(By.xpath("//button[@title='Assign Leave']")).click();
    boolean ans2 = driver.findElement(By.xpath("//h6[text()='Leave']")).getText().equals("Leave");
    Assert.assertTrue(ans2,"Page not loaded properly");
    if (ans2) {
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("oran");
        Thread.sleep(3000);
        
        String visibledValue="";
        List <WebElement> ls = driver.findElements(By.xpath("//div[@role='listbox']"));
         
          for(WebElement l : ls){
           // System.out.println( l.getText());
            if (l.getText().equalsIgnoreCase("Orange Test")) {
                  visibledValue = l.getText();
                l.click();

                break;
               // Assert.assertEquals(visibledValue, selectedValue);
            }
                String selectedValue =  driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).getAttribute("value");
                System.out.println(visibledValue +" vs "+selectedValue);

            Assert.assertEquals(visibledValue, "Orange Test");
            Assert.assertEquals(selectedValue, "Orange  Test");

          }
        } 
    }
    

@AfterClass
public void teardown() throws InterruptedException {
    Thread.sleep(15000);
driver.quit();
}

}
