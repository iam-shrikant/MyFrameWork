package com.myframework.testcases.homepage;

import com.myframework.base.BaseClass;
import com.myframework.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyHomeScreen extends BaseClass {

    private HomePage homePage;
    public static final String HOME_PAGE_TITLE = "My Shop";
    public static final List<String> HOME_PAGE_MENU = new ArrayList<String>(Arrays.asList("WOMEN","DRESSES","T-SHIRTS","BLOG"));

    @BeforeClass
    public void beforeClass(){
        System.out.println("VerifyHomeScreen beforeClass Thread NO : "+Thread.currentThread().getId());
        setupDriver();
        launchWebsite();
        homePage = new HomePage();
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("VerifyHomeScreen Thread NO : "+Thread.currentThread().getId());
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("VerifyHomeScreen Thread NO : "+Thread.currentThread().getId());
    }

    @Test(priority = 0)
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

    @AfterClass
    public void afterClass(){
        System.out.println("Thread NO : "+Thread.currentThread().getId());
        doEndTest();
    }
}