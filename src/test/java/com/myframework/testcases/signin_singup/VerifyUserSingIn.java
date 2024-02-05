package com.myframework.testcases.signin_singup;

import com.myframework.base.BaseClass;
import com.myframework.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyUserSingIn extends BaseClass {
    //tc1: verify signin button is visible or not
    //tc2: verify user is able to click on signin button
    //tc3: verify user tap on signin button
    //tc4: verify user provided wrong login details
    //tc5: verify user provided correnct login details
    //tc6: verify login successfull
    private HomePage homePage;

    @BeforeTest()
    public void beforeTest(){
        setupDriver();
        launchWebsite();
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void verifySignInBtnIsVisible(){
        Assert.assertTrue(homePage.isSignInBtnDisplayed());
    }

    @Test(priority = 2)
    public void verifySignInBtnIsClickable(int WAIT_TIME_20_SECOND){
        Assert.assertTrue(homePage.isSignInBtnClickable(WAIT_TIME_20_SECOND));
    }

    @Test(priority = 3)
    public void verifyUserTapOnSignInBtn(){
        homePage.clickOnSignInbtn();
    }

    @Test()
    public void verifyUserLogin(){

    }


    @AfterTest
    public void afterTest(){
        doEndTest();
    }
}
