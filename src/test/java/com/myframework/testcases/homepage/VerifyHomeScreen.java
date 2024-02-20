package com.myframework.testcases.homepage;


import com.myframework.pages.HomePage;
import com.myframework.testcases.basetest.BaseTestClass;
import com.myframework.utitlies.Log;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyHomeScreen extends BaseTestClass {

    public static final String HOME_PAGE_TITLE = "My Shop";
    public static final List<String> HOME_PAGE_MENU = new ArrayList<String>(Arrays.asList("WOMEN","DRESSES","T-SHIRTS","BLOG"));


    @Test(priority = 0,groups = {"smoke"})
    public void verifyHomePageTitle(){
        String title = homePage.getPageTitle();
        Assert.assertEquals(title,HOME_PAGE_TITLE);
    }

    @Test(priority = 1)
    public void verifySignInBtnIsVisible(){
        Assert.assertTrue(homePage.isSignInBtnDisplayed());
    }

    @Test(priority = 2)
    public void verifyMainMenuOptions(){
       Assert.assertTrue(homePage.verifyMainMenuOptions(HOME_PAGE_MENU));
    }

    /*@Test(priority = 3)
    public void failedTestCase(){
        Assert.assertTrue(false);
    }

    @Test(priority =4)
    public void skippedTestCase(){
        throw new SkipException("this is skipped test case");
    }

    @Test(priority =5, enabled = false)
    public void skippedTestCase2(){
    }*/

}
