package com.selenium_testng.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotListener {
    //WebDriver driver;

    static String FolderPath = System.getProperty("user.dir") + "\\Screenshots";
    static String filepath = FolderPath + "\\\\";

    /*public screenshotListener(WebDriver driver) {
        this.driver = driver;
        System.out.println("screenshot got driver");

    }*/

    static {
        File folder = new File(FolderPath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdir();
            System.out.println("Screenshot Folder created " + folder.getPath());
        } else {
            System.out.println("Folder found " + folder.getPath());
        }
    }

    public static String captureScreenshot(WebDriver driver,String testcase) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = filepath + testcase + "_" + System.currentTimeMillis() + ".png";
        File Destination = new File(filename);
        System.out.println(Destination.getAbsolutePath());
        try {
            FileUtils.copyFile(source, Destination);
            return Destination.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("Unable to capture screenshot");
            e.printStackTrace();
            return null;
        }

    }
}
