package com.myframework.testcases.homepage;


import com.myframework.pages.HomePage;
import com.myframework.testcases.basetest.BaseTestClass;
import org.testng.Assert;
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


}
