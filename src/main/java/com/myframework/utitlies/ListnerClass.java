package com.myframework.utitlies;

import org.testng.*;

public class ListnerClass implements ISuiteListener, IClassListener,ITestListener {

    /*
    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
*/
    @Override
    public void onStart(ISuite suite) {
        //ISuiteListener.super.onStart(suite);
        ExtentReportManager.initReport();
    }
    @Override
    public void onBeforeClass(ITestClass testClass) {
        //IClassListener.super.onBeforeClass(testClass);
        ExtentReportManager.createTest(testClass);
    }


    @Override
    public void onTestStart(ITestResult result) {
        //ExtentLogger.reportInfo(result.getName()+" Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.reportPassedTestCase(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.reportPassedTestCase(result);
        Log.error(result.getName()+" - Failed -"+result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //System.out.println("ListnerClass - onTestSkipped "+result.getName());
        ExtentLogger.reportSkippedTestCase(result);
        Log.error(result.getName()+" - Skipped -"+result.getThrowable().getMessage());
    }


    @Override
    public void onAfterClass(ITestClass testClass) {
        IClassListener.super.onAfterClass(testClass);
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }
}
