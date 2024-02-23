package com.myframework.testcases.scrachcode;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myframework.utitlies.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestClass {

    ArrayList<ArrayList<String>> masterData;

    public ExtentReports extent;
    public ExtentSparkReporter spark;

    public void setupReport(){
        spark = new ExtentSparkReporter("test-output/spart_report.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Testing reports");
        spark.config().setReportName("AutomationReport");
        //spark.lo
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public void flushReport(){
        extent.flush();
    }

    public static void main(String[] args) {

    }
}
