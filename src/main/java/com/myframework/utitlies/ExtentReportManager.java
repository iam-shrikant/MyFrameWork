package com.myframework.utitlies;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager {

    public ExtentReports report;
    public ExtentSparkReporter allReporter;
    public ExtentSparkReporter failedReporter;
    public ExtentTest extentTest;
    public ExtentReportManager() {
        final File CONF = new File(System.getProperty("user.dir")+"/Configuration/extent-config.xml");

        allReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/index.html");
        try {
            allReporter.loadXMLConfig(CONF);
        } catch (IOException e) {
            Log.error("ExtentReportManager - ExtentReportManager() - Got exception :",e);
        }

        failedReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/failed-testCases.html");
        failedReporter.filter().statusFilter().as(new Status[]{Status.FAIL});
        failedReporter.config().setReportName("Failed test cases");


        report = new ExtentReports();
        report.attachReporter(allReporter,failedReporter);
        report.setSystemInfo("OS","Window 11");
        report.setSystemInfo("Browsers","Chrome,FireFox");
    }

    public void createTest(ITestResult result){
        extentTest = report.createTest(result.getName());
    }

    public void reportFailedTestCase(ITestResult result){
        extentTest.log(Status.FAIL, MarkupHelper.createLabel("Failed Test Case: "+result.getName(), ExtentColor.RED));
    }

    public void reportPassedTestCase(ITestResult result){
        extentTest.log(Status.PASS, MarkupHelper.createLabel("Passed Test Case: "+result.getName(), ExtentColor.GREEN));
    }

    public void reportSkippedTestCase(ITestResult result){
        extentTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped Test Case: "+result.getName(), ExtentColor.YELLOW));
    }

    public void flushReport(){
        report.flush();
    }
}
