package com.selenium_testng.Practice_Testcases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenshotListener {
    WebDriver driver;
    static String folderpath = System.getProperty("user.dir")+"\\screenshots\\";
    

  static{   
    File folder = new File(folderpath);
    if (!folder.exists() && !folder.isDirectory()){
        folder.mkdir();
        System.out.println("Folder created at "+folderpath);
    }else{
        System.out.println("Checked : folder present at "+folderpath);
    }}

public static void captureThis(String testcase,WebDriver driver){
    try {
    File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    
    File destination = new File(folderpath+testcase+"_"+System.currentTimeMillis()+".png");
    FileUtils.copyFile(source, destination);
    System.out.println(testcase+" Captured");
    } catch (Exception e) {
        System.out.println("Unable to capture screenshot");
    }
}

 
}
