package com.selenium_testng.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonMethods {
WebDriver driver;
WebDriverWait wait;
public commonMethods(WebDriver driver){
    this.driver=driver;
    this.wait =  new WebDriverWait(driver, Duration.ofSeconds(8)); 
}
    public void waitAndClick(WebElement ele){
    
    wait.until(ExpectedConditions.elementToBeClickable(ele));
    ele.click();
    
}
public void waitAndTillClickable(WebElement ele){
    
    wait.until(ExpectedConditions.elementToBeClickable(ele));    
    
}

public void WaitTillVisible(By ele){
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(ele));    
    
}
public void visibilityOf(WebElement ele){
    
    wait.until(ExpectedConditions.visibilityOf(ele));    
    
}
public void invisibilityOfText(WebElement ele){
    
    wait.until(driver->(!ele.getText().contains("Search")));    
  
    
}
// public void login(){
//       //  login.loginToApp("Admin", "admin123");
//     System.out.println("---Logged in successfully---");
// }

}
