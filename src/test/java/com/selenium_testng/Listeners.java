package com.selenium_testng;


import org.testng.ITestContext; 
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.selenium_testng.base.base;
import com.selenium_testng.utils.ReportListener;
import com.selenium_testng.utils.screenshotListener;


public class Listeners implements ITestListener {
    ExtentReports extent = ReportListener.reportGenerator();
   // ExtentTest test ;
    private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
    ExtentTest currenttest = extent.createTest(result.getMethod().getMethodName());   
    extentTest.set(currenttest);
       
    }
    @Override
    public void onTestSuccess(ITestResult result) {
       
        extentTest.get().log(Status.PASS, "PASSSSS");
        String path = screenshotListener.captureScreenshot(base.getDriver(),result.getMethod().getMethodName());
        extentTest.get().pass(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        
        extentTest.get().fail(result.getThrowable());
        String path = screenshotListener.captureScreenshot(base.getDriver(),result.getMethod().getMethodName());
        extentTest.get().fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }    
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
      //  ITestListener.super.onFinish(context);
    }

    
   

  

}
