package com.selenium_testng.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportListener {
   // ExtentSpark Report, ExtentReports
    
    
   
    static ExtentReports extent;

    public static ExtentReports reportGenerator() {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("first report document title");
        reporter.config().setReportName("Selenium testNG report");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        System.out.println("report done 1 at ="+path);
        return extent;

    }






}
