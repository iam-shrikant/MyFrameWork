package com.myframework.testcases.basetest;

import com.myframework.base.BaseClass;
import com.myframework.pages.HomePage;
import com.myframework.utitlies.Log;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTestClass extends BaseClass {

    public HomePage homePage;
    @BeforeSuite(alwaysRun = true)
    public void beforeSuit(){
        Log.info("Test Suit Execution Started");
        System.out.println("beforeSuit");
    }

    @Parameters(value = "browser")
    @BeforeClass(alwaysRun = true)
    public void beforeClass(@Optional("firefox") String browser){
        Log.info("beforeClass Started on Browser -"+browser);
        //System.out.println(browser+ "VerifyHomeScreen beforeClass Thread NO : "+Thread.currentThread().getId());
        setupDriver(browser);
        launchWebsite();
        homePage = new HomePage();
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result){
        Log.info(this.getClass().getName()+" Test cases Started - "+result.getMethod().getMethodName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        Log.info(this.getClass().getName()+" Test cases Started - "+result.getMethod().getMethodName());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        //System.out.println("VerifyHomeScreen afterClass Thread NO : "+Thread.currentThread().getId());
        doEndTest();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuit(){
        Log.info("Test Suit Execution Ended");
        System.out.println("afterSuit");
    }
}
