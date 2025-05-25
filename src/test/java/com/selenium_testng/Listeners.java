package com.selenium_testng;


import org.testng.ITestContext; 
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.selenium_testng.TestCases.baseTest;
import com.selenium_testng.utils.ReportListener;


public class Listeners extends baseTest implements ITestListener {
    ExtentReports extent = ReportListener.reportGenerator();
    ExtentTest test ;
    private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
    test = extent.createTest(result.getMethod().getMethodName());   
    extentTest.set(test);
       
    }
    @Override
    public void onTestSuccess(ITestResult result) {
       
        extentTest.get().log(Status.PASS, "PASS");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        
        extentTest.get().fail(result.getThrowable());
       // extentTest.get().fail(MediaEntityBuilder.createScreenCaptureFromPath(pom.getScreenshotObject().screenshot(getDriver(), result.getMethod().getMethodName())).build());
    }    
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
      //  ITestListener.super.onFinish(context);
    }

    
   

  

}
