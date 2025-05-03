package com.selenium_testng.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotListener {
    WebDriver driver;
    int count=0;
    
    static String FolderPath = System.getProperty("user.dir")+"\\src\\Screenshots"; 
    String path = FolderPath+"\\\\";
    
    public screenshotListener(WebDriver driver){
        this.driver = driver;
    }

    static{
        File folder = new File(FolderPath);
            if(!folder.exists() && !folder.isDirectory()){
                folder.mkdir();
                System.out.println("Screenshot Folder created "+folder.getPath());
            } else{
                System.out.println("Folder found "+folder.getPath());
            }
    }

    public void screenshot(String testcase){
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        File Destination = new File(path+testcase+"_"+System.currentTimeMillis()+".png");
        System.out.println(Destination);
        try {
            FileUtils.copyFile(source,Destination);
        } catch (IOException e) {
            System.out.println("Unable to capture screenshot");
            e.printStackTrace();
        }

    }
}
