package com.selenium_testng.Practice_Testcases;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class InvalidLogin {
    WebDriver driver;
@BeforeClass
public void init(){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Desktop\\stng\\target\\chromedriver.exe");
    driver=new ChromeDriver();

}
//challange 2
@Test(priority = 0)
public void ValidateLoginFeature(){
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   // driver.manage().window().maximize();
    driver.findElement((By.xpath("//input[@name='username']"))).sendKeys("Admin1");;
    driver.findElement((By.xpath("//input[@name='password']"))).sendKeys("admin123");
  //  driver.findElement(By.xpath("//div/button[@type='submit']")).click();
    driver.findElement(By.xpath("//div/button[@type='submit']")).submit();
   boolean ans = driver.findElement(By.xpath("//div/i/following-sibling::p")).getText().equals("Invalid credentials");
   
   Assert.assertTrue(ans);

}

    
    

@AfterClass
public void teardown() throws InterruptedException {
    Thread.sleep(15000);
driver.quit();
}

}
