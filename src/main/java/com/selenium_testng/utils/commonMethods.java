package com.selenium_testng.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonMethods {
    WebDriver driver;
    WebDriverWait wait;

    public commonMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void waitAndClick(WebElement ele) {

        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();

    }
    public String getHeader(WebElement ele) {

        wait.until(ExpectedConditions.elementToBeClickable(ele));
        return ele.getText();

    }

    public void waitAndTillClickable(WebElement ele) {

        wait.until(ExpectedConditions.elementToBeClickable(ele));

    }

    public void WaitTillVisible(By ele) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(ele));

    }

    public void visibilityOf(WebElement ele) {

        wait.until(ExpectedConditions.visibilityOf(ele));

    }

    

    public void WaitTillSearchDisappeared(List<WebElement> eleList) {
        //wait.until(driver -> eleList.size()>1); // optional alternate workaroundd

        wait.until(driver -> {
            for(WebElement ele : eleList){
                try {
                    if(ele.isDisplayed() && ele.getText().contains("Search")){
                        return false;
                    }
                } catch (Exception e) {
                   return false;
                }
            }
            return true;


        });

    }
  

}
