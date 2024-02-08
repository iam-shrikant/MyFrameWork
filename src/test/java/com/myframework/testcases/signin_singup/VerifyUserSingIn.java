package com.myframework.testcases.signin_singup;

import com.myframework.base.BaseClass;
import com.myframework.pages.AccountPage;
import com.myframework.pages.HomePage;
import com.myframework.pages.SignInSIgnup;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class VerifyUserSingIn extends BaseClass {
    //tc1: verify sign-in button is visible or not
    //tc2: verify user is able to click on sign-in button
    //tc3: verify user tap on sign-in button
    //tc4: verify user provided wrong login details
    //tc5: verify user provided correct login details
    //tc6: verify login successful
    private HomePage homePage;
    private SignInSIgnup signInSignUpPage;
    private AccountPage accountPage;

    @BeforeClass()
    public void beforeClass(){
        System.out.println("VerifyUserSingIn beforeClass- beforeClass Thread NO : "+Thread.currentThread().getId());
        setupDriver();
        launchWebsite();
        homePage = new HomePage();
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("VerifyUserSingIn Thread NO : "+Thread.currentThread().getId());
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("VerifyUserSingIn Thread NO : "+Thread.currentThread().getId());
    }

    @Test(priority = 1)
    public void verifySignInBtnIsVisible(){
        Assert.assertTrue(homePage.isSignInBtnDisplayed());
    }

    @Test(priority = 2)
    public void verifySignInBtnIsClickable(){
        Assert.assertTrue(homePage.isSignInBtnClickable(WAIT_TIME_20_SECOND));
    }

    @Test(priority = 3)
    public void verifyUserTapOnSignInBtn(){
        signInSignUpPage = homePage.clickOnSignInbtn();
    }

    @Test(priority = 4, enabled = true, dataProvider = "invalidLoginData", dataProviderClass = com.myframework.testcases.dataproviders.loginDataProviders.class)
    public void verifyInvalidUserLogin(String emailId, String password){

        SoftAssert softAssert = new SoftAssert();
        signInSignUpPage.enterEmailAddress(emailId);
        signInSignUpPage.enterPassword(password);
        signInSignUpPage.clickOnSignInbtn();
        softAssert.assertTrue(signInSignUpPage.isErrorDisplayed());
        softAssert.assertEquals("Authentication failed.",signInSignUpPage.readError(),"Validation error");
        softAssert.assertAll();
    }

    @Test(priority = 5,enabled = false, dataProvider = "validLoginData", dataProviderClass = com.myframework.testcases.dataproviders.loginDataProviders.class)
    public void verifyValidUserLogin(String emailId, String password){
        //SoftAssert softAssert = new SoftAssert();
        signInSignUpPage.enterEmailAddress(emailId);
        signInSignUpPage.enterPassword(password);
        accountPage = signInSignUpPage.clickOnSignInbtn();
        Assert.assertEquals(AccountPage.pageTitle,accountPage.getPageTitle());
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Thread NO : "+Thread.currentThread().getId());
        doEndTest();
    }
}
