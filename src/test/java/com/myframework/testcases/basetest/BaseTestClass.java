package com.myframework.testcases.basetest;

import com.myframework.base.BaseClass;
import com.myframework.pages.HomePage;
import com.myframework.utitlies.Log;
import org.testng.annotations.*;

public class BaseTestClass extends BaseClass {

    public HomePage homePage;
    @BeforeSuite(alwaysRun = true)
    public void beforeSuit(){
        Log.info("Test Suit Execution Started");
        //System.out.println("beforeSuit");
    }

    @Parameters(value = "browser")
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String browser){
        Log.info("beforeClass Started on Browser -"+browser);
        //System.out.println(browser+ "VerifyHomeScreen beforeClass Thread NO : "+Thread.currentThread().getId());
        setupDriver(browser);
        launchWebsite();
        homePage = new HomePage();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        //System.out.println("VerifyHomeScreen afterClass Thread NO : "+Thread.currentThread().getId());
        doEndTest();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuit(){
        Log.info("Test Suit Execution Ended");
        //System.out.println("afterSuit");
    }
}
