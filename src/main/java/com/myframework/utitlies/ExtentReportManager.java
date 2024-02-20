package com.myframework.utitlies;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestClass;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReportManager {

    private static ExtentReports report;
    private static ExtentSparkReporter allReporter;
    private static ExtentSparkReporter failedReporter;
    //private static ExtentTest extentTest;

    private ExtentReportManager() {

    }

    public static void initReport(){
        if(Objects.isNull(report)){
            //final File CONF = new File(System.getProperty("user.dir")+"/Configuration/extent-config.xml");
            allReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/extent-test-output/index.html");
            allReporter.config().setReportName("Automation Suit Report");
            allReporter.config().setTheme(Theme.STANDARD);
            allReporter.config().setDocumentTitle("Automation Suit Test cases");
            /*try {
                allReporter.loadXMLConfig(CONF);
            } catch (IOException e) {
                Log.error("ExtentReportManager - ExtentReportManager() - Got exception :",e);
            }*/

            failedReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/extent-test-output/failed-testCases.html");
            failedReporter.filter().statusFilter().as(new Status[]{Status.FAIL});
            failedReporter.config().setReportName("Failed Test Report");
            failedReporter.config().setTheme(Theme.DARK);
            failedReporter.config().setDocumentTitle("Failed Test cases");

            report = new ExtentReports();
            report.attachReporter(allReporter,failedReporter);
            report.setSystemInfo("OS","Window 11");
            report.setSystemInfo("Browsers","Chrome,FireFox");
        }
    }

    public static void createTest(ITestClass result){
        ExtentTest extentTest = report.createTest(result.getName());
        ExtentTestManager.setExtentTest(extentTest);
    }



    public static void flushReport(){
        if(Objects.nonNull(report)){
            report.flush();
        }
    }
}
