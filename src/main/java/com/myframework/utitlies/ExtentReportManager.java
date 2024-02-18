package com.myframework.utitlies;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager {
    public ExtentReports report;
    public ExtentSparkReporter allReporter;
    public ExtentSparkReporter failedReporter;
    public ExtentTest extentTest;


    public void initExtentReport() throws IOException {
        final File CONF = new File(System.getProperty("user.dir")+"/Configuration/extent-config.xml");

        allReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/index.html");
        allReporter.loadXMLConfig(CONF);

        failedReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/failed-testCases.html");
        failedReporter.filter().statusFilter().as(new Status[]{Status.FAIL});
        failedReporter.config().setReportName("Failed test cases");


        report = new ExtentReports();
        report.attachReporter(allReporter,failedReporter);
        report.setSystemInfo("OS","Window 11");
        report.setSystemInfo("Browsers","Chrome,FireFox");
    }

    public void flushReport(){
        report.flush();
    }
}
