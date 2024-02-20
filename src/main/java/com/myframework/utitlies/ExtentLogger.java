package com.myframework.utitlies;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestResult;

public final class ExtentLogger {
    private ExtentLogger(){

    }

    public static void reportFailedTestCase(ITestResult result){
        ExtentTestManager.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel("Failed Test Case: "+result.getName(), ExtentColor.RED));

    }

    public static void reportPassedTestCase(ITestResult result){
        ExtentTestManager.getExtentTest().log(Status.PASS, MarkupHelper.createLabel("Passed Test Case: "+result.getName(), ExtentColor.GREEN));
    }

    public static void reportSkippedTestCase(ITestResult result){
        ExtentTestManager.getExtentTest().log(Status.SKIP, MarkupHelper.createLabel("Skipped Test Case: "+result.getName(), ExtentColor.YELLOW));
    }

    public static void reportInfo(String message){
        ExtentTestManager.getExtentTest().log(Status.INFO,MarkupHelper.createLabel(message,ExtentColor.LIME));
    }

}
