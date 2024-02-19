package com.myframework.utitlies;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener {
    private ExtentReportManager extentReportManager;
    @Override
    public void onStart(ITestContext context) {
        //ITestListener.super.onStart(context);
        System.out.println("ListnerClass -onStart "+context.getName());
        extentReportManager = new ExtentReportManager();
    }

    @Override
    public void onTestStart(ITestResult result) {
        //ITestListener.super.onTestStart(result);
        System.out.println("ListnerClass - onTestStart "+result.getName());
        extentReportManager.createTest(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //ITestListener.super.onTestSuccess(result);
        System.out.println("ListnerClass - onTestSuccess "+result.getName());
        extentReportManager.reportPassedTestCase(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //ITestListener.super.onTestFailure(result);
        System.out.println("ListnerClass - onTestFailure "+result.getName());
        extentReportManager.reportFailedTestCase(result);
        Log.error(result.getName()+" - Failed -"+result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //ITestListener.super.onTestSkipped(result);
        System.out.println("ListnerClass - onTestSkipped "+result.getName());
        extentReportManager.reportSkippedTestCase(result);
        Log.error(result.getName()+" - Skipped -"+result.getThrowable().getMessage());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        //System.out.println("ListnerClass -");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        //ITestListener.super.onTestFailedWithTimeout(result);
        //System.out.println("ListnerClass -");
    }

    @Override
    public void onFinish(ITestContext context) {
        //ITestListener.super.onFinish(context);
        System.out.println("ListnerClass -onFinish "+context.getName());
        extentReportManager.flushReport();
    }


}
