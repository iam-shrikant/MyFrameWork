package com.myframework.testcases.homepage;

import com.myframework.base.BaseClass;
import com.myframework.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class VerifyHomeScreen extends BaseClass {

    private HomePage homePage;
    public static final String HOME_PAGE_TITLE = "My Shop";
    @BeforeTest
    public void beforeTest(){
        setupDriver();
        launchWebsite();
        homePage = new HomePage();
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

    @AfterTest
    public void afterTest(){
        doEndTest();
    }
}
